// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com
package UI;

import Controller.UIClient.UIClientController;
import Model.components.MotionPanel;
import Model.cuentas.Cuenta;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class UIClient extends JFrame {

    private Dimension size;
    private JPanel panel;
    private JButton buttonRetirar;
    private JButton buttonSalir;
    private JButton dineroRapidoButton;
    private JButton buttonDepositar;
    private JLabel labelSaldoDebito;
    private JLabel labelNombre;
    private JLabel labelTituloCuentaDebito;
    private JLabel labelTituloSaldoAhorro;
    private JLabel ahorro;
    private JButton buttonMinimizar;
    private JPanel movedPanel;
    private JLabel labelSaldoAhorro;
    private JButton buttonTransferir;
    private Cuenta cuenta;
    private UIClientController controller;
    menuDeposito menu = new menuDeposito(this);

    public UIClient(Cuenta cuenta, UIClientController controller) {
        super("Gestor de cuentas");
        this.setUndecorated(true);
        size = new Dimension(680, 464);
        this.setContentPane(panel);
        this.setSize(size);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.cuenta = cuenta;
        this.controller = controller;
        buttonDepositar.addActionListener(controller);
        buttonDepositar.setActionCommand("depositar");
        buttonSalir.addActionListener(controller);
        buttonSalir.setActionCommand("salir");
        buttonRetirar.addActionListener(controller);
        buttonRetirar.setActionCommand("retirar");
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/user-account.png"));
        setIconImage(image);
        buttonMinimizar.addActionListener(controller);
        buttonMinimizar.setActionCommand("minimizar");
        buttonTransferir.addActionListener(controller);
        buttonTransferir.setActionCommand("transferir");
    }

    public Cuenta getCuenta() {
        return this.cuenta;
    }

    public double showMenuDepositar() {
       /* this.getContentPane().removeAll();
        this.getContentPane().invalidate();
        this.setContentPane(menu.getContentPane());
        this.getContentPane().revalidate();*/
        //this.repaint();
        //this.update(this.getGraphics());
        double saldo = 0;
        try{
            saldo = Double.parseDouble(JOptionPane.showInputDialog(this, "Monto a depositar", "Deposito", JOptionPane.QUESTION_MESSAGE));
        }catch (NullPointerException e){
            System.err.println("No se ingreso ninguna cantidad");
        }

        return saldo;
    }

    public void updateGUI() {

        double saldo_actual = cuenta.getSaldoActual();

        DecimalFormat formateador = new DecimalFormat("$###,###,###.##");
        String saldo_actual_txt = formateador.format(saldo_actual);
        String name = cuenta.getPropietario().getNombre() + " " + cuenta.getPropietario().getApellidoPaterno();
        String tipo_cuenta = cuenta.getTipoCuenta();

        labelNombre.setText(name);
        switch (tipo_cuenta) {
            case "debito":
                this.labelTituloCuentaDebito.setText("Debito #1");
                labelSaldoDebito.setText(saldo_actual_txt);
                labelSaldoDebito.setText(formateador.format(saldo_actual));
                labelSaldoAhorro.setVisible(false);
                ahorro.setVisible(false);
                labelTituloSaldoAhorro.setVisible(false);
                break;
            case "credito":
                labelSaldoAhorro.setVisible(false);
                this.labelTituloCuentaDebito.setText("Credito #1");
                labelSaldoDebito.setText(saldo_actual_txt);
                labelSaldoDebito.setText(formateador.format(saldo_actual));

                ahorro.setVisible(false);
                labelTituloSaldoAhorro.setVisible(false);
                break;
            case "ahorro":
                labelSaldoDebito.setVisible(false);
                labelTituloCuentaDebito.setVisible(false);


                labelTituloSaldoAhorro.setText("Ahorro #1");
                labelSaldoAhorro.setText(saldo_actual_txt);
                break;
        }

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        buttonMinimizar = new JButton("");
        buttonMinimizar.setMargin(null);
        movedPanel = new MotionPanel(this);
        ahorro = new JLabel();
    }

}