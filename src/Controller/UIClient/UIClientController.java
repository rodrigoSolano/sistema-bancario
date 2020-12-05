// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com
package Controller.UIClient;

import Controller.App.ControllerApp;
import Model.cuentas.Cuenta;
import UI.UIClient;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIClientController implements ActionListener {
    private UIClient uiCliente;
    private ControllerApp controllerApp;

    public void setUiCliente(UIClient uiCliente) {
        this.uiCliente = uiCliente;
    }

    public void setControllerApp(ControllerApp controllerApp) {
        this.controllerApp = controllerApp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Cuenta cuenta = uiCliente.getCuenta();
        switch (command) {
            case "depositar":
                double saldo = 0;
                try {
                    saldo = uiCliente.showMenuDepositar();
                    if(saldo == -1){
                        return;
                    }
                }catch (NumberFormatException err){
                    System.err.println("No se ingreso ninguna cantidad");
                    JOptionPane.showConfirmDialog(uiCliente,"No se ingreso ninguna cantidad","Error",JOptionPane.DEFAULT_OPTION);
                    return;
                }

                if (cuenta.depositarSaldo(saldo)) {
                    JOptionPane.showConfirmDialog(null,"Deposito Correcto","Confirmar",JOptionPane.DEFAULT_OPTION);
                    uiCliente.updateGUI();
                } else {
                    System.err.println("No se puedo realizar el deposito");
                }
                break;

            case "retirar":
                double saldo_retirar = 0;
                saldo_retirar = Double.parseDouble(JOptionPane.showInputDialog("monto a retirar"));
                if(cuenta.retirarSaldo(saldo_retirar) != -1){
                    JOptionPane.showConfirmDialog(null,"Retiro Correcto","Confirmar",JOptionPane.DEFAULT_OPTION);
                    uiCliente.updateGUI();
                }else{
                    JOptionPane.showConfirmDialog(null,"Nose puedo realizar el rertiro","Error", JOptionPane.CLOSED_OPTION);
                }
                break;
            case "minimizar":
                uiCliente.setState(JFrame.ICONIFIED);
                break;
            case "salir":
                uiCliente.dispose();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                controllerApp.logOut();

                break;
            case "transferir":
                double montoTrasnsferir = Double.parseDouble(JOptionPane.showInputDialog(uiCliente,"Monto transferir"));
                int numeroCuentaDestino = Integer.parseInt(JOptionPane.showInputDialog(uiCliente,"Numero cuenta destino"));
                if(cuenta.transferir(montoTrasnsferir,numeroCuentaDestino)){
                    JOptionPane.showConfirmDialog(uiCliente,"Transferencia exitosa!!!","ok",JOptionPane.DEFAULT_OPTION);
                    uiCliente.updateGUI();
                }else{
                    JOptionPane.showConfirmDialog(uiCliente,"Ocurrio un error en la transferencia","Error",JOptionPane.DEFAULT_OPTION);
                }

        }

    }

}