// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com
package Controller.Login;

import Controller.App.ControllerApp;
import Model.conexion.Conexion;
import Model.cuentas.*;
import UI.LoginUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginUIController extends MouseAdapter implements ActionListener {

    private LoginUI loginUI;
    private ControllerApp controllerApp;

    public void setUI(LoginUI loginUI) {
        this.loginUI = loginUI;
    }

    public void setLoginUI(LoginUI loginUI) {
        this.loginUI = loginUI;
    }

    public void setControllerApp(ControllerApp controllerApp) {
        this.controllerApp = controllerApp;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        System.out.println(e.getPoint());
        loginUI.setLocation(e.getPoint());
        System.out.println(e.getX());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        System.out.println("enter");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("login")) {

            int[] datos = obtenerDatosGUI();

            if (datos != null) {
                int numeroCuenta = datos[0];
                int nip = datos[1];
                Cuenta cuenta = login(numeroCuenta, nip);
                if (cuenta != null) {
                    this.loginUI.dispose();
                    controllerApp.startApp(cuenta);
                } else {
                    JOptionPane.showConfirmDialog(null, "Numero o NIP de cuenta no valido","Error",JOptionPane.DEFAULT_OPTION);
                }
            }

        } else if (command.equals("exit")) {
            System.exit(0);
        }else if(command.equals("minimizar")){
            loginUI.setState(1);
        }
    }

    public int[] obtenerDatosGUI() {
        int datos[] = new int[2];
        try {
            int numeroCuenta = Integer.parseInt(loginUI.getNumeroCuentaField().getText().toString());
            int nip = Integer.parseInt(new String(loginUI.getNipField().getPassword()));
            System.out.println(numeroCuenta);
            System.out.println(nip);
            datos[0] = numeroCuenta;
            datos[1] = nip;

        } catch (NumberFormatException error) {
            System.err.println("Numero de cuenta o nip no validos");
            System.out.println(error);
            return null;
        }

        return datos;
    }

    public Cuenta login(int numeroCuenta, int nip_gui) {
        Cuenta cuenta = null;
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM cuentas WHERE numero_cuenta = " + numeroCuenta + " and nip = " + nip_gui;
        String nombre = null;
        String apellidoPaterno;
        String apellidoMaterno;
        String rfc = null;
        String direccion = null;
        String telefono = null;
        int nip_cuenta = 0;

        try {
            connection = Conexion.conectar();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            int id_cliente = 0;
            int saldo_actual = 0;
            String tipo_cuenta = "";


            while (resultSet.next()) {
                id_cliente = resultSet.getInt("id_cliente");
                tipo_cuenta = resultSet.getString("tipo_cuenta");
                saldo_actual = resultSet.getInt("saldo_actual");
                nip_cuenta = resultSet.getInt("nip");
            }


            if (id_cliente == 0) {
                return null;
            }

            query = "SELECT * FROM clientes WHERE id_cliente = " + id_cliente;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                nombre = resultSet.getString("nombre_completo");
                rfc = resultSet.getString("rfc");
                direccion = resultSet.getString(("direccion"));
                telefono = resultSet.getString("telefono");
            }

            String[] data_name = nombre.split(" ");
            nombre = data_name[0];
            apellidoMaterno = data_name[1];
            apellidoPaterno = data_name[1];

            Propietario propietario = new Propietario(nombre, apellidoPaterno, apellidoMaterno, direccion, telefono, rfc);

            switch (tipo_cuenta) {
                case "debito":
                    cuenta = new CuentaDebito(propietario, numeroCuenta, saldo_actual, id_cliente);
                    break;
                case "credito":
                    cuenta = new CuentaCredito(propietario, numeroCuenta, saldo_actual, id_cliente);
                    break;
                case "ahorro":
                    cuenta = new CuentaAhorro(propietario, numeroCuenta, saldo_actual, id_cliente);
                    break;
                default:
                    System.err.println("tipo cuenta desconocido!!!");
            }

            statement.close();
            resultSet.close();
            connection.close();
            return cuenta;

        } catch (SQLException e) {
            System.out.println("Error: no se pudieron obtener los datos");
            e.printStackTrace();
            return null;
        }


    }
}
