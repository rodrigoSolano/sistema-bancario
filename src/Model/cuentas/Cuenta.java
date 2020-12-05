// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com
package Model.cuentas;

import Model.conexion.Conexion;
import Model.conexion.Movimientos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cuenta implements Movimientos {

    private Propietario propietario;
    private int id_cliente;
    private final int numero_cuenta;
    private double saldo_actual;
    private final String tipoCuenta;

    public Cuenta(Propietario cliente, int numeroCuenta, int saldo_actual, String tipoCuenta) {
        this.propietario = cliente;
        this.numero_cuenta = numeroCuenta;
        this.saldo_actual = saldo_actual;
        this.tipoCuenta = tipoCuenta;
    }

    public Cuenta(int numeroCuenta, int saldo_actual, String tipoCuenta, int id_cliente) {
        this.id_cliente = id_cliente;
        this.numero_cuenta = numeroCuenta;
        this.saldo_actual = saldo_actual;
        this.tipoCuenta = tipoCuenta;
    }

    public Cuenta(Propietario propietario, int numeroCuenta, int saldo_actual, String tipoCuenta, int id_cliente) {
        this.id_cliente = id_cliente;
        this.numero_cuenta = numeroCuenta;
        this.saldo_actual = saldo_actual;
        this.tipoCuenta = tipoCuenta;
        this.propietario = propietario;
    }


    @Override
    public double consultarSaldo() {
        double saldo_actual = 0;
        Statement statement;
        Connection connection;
        ResultSet resultSet;
        String query = "SELECT saldo_actual FROM cuentas WHERE numero_cuenta = " + this.numero_cuenta;

        connection = Conexion.conectar();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                saldo_actual = resultSet.getDouble("saldo_actual");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return saldo_actual;
    }

    public double consultarSaldoParaTransferir(int numero_cuenta) {
        double saldo = 0;
        Statement statement;
        Connection connection;
        ResultSet resultSet;
        String query = "SELECT saldo_actual FROM cuentas WHERE numero_cuenta = " + numero_cuenta;

        connection = Conexion.conectar();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                saldo = resultSet.getDouble("saldo_actual");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }

        return saldo;
    }

    @Override
    public double retirarSaldo(double saldo_retirar) {

        double saldoPosterior = consultarSaldo() - saldo_retirar;

        if (saldoPosterior < 0) {
            return -1;
        }

        Statement statement;
        Connection connection;

        String sql = "UPDATE cuentas SET saldo_actual = " + saldoPosterior + " WHERE numero_cuenta = " +
                this.numero_cuenta;

        try {
            connection = Conexion.conectar();
            statement = connection.createStatement();
            statement.execute(sql);

        } catch (SQLException e) {
            System.err.println("Error: no se pudieron actualizar los datos");
            return -1;
        }

        this.saldo_actual = consultarSaldo();
        return saldo_retirar;
    }

    @Override
    public boolean depositarSaldo(double montoDepositar) {

        if (montoDepositar > 0) {
            montoDepositar = consultarSaldo() + montoDepositar;
            Statement statement;
            Connection connection;

            String sql = "UPDATE cuentas SET saldo_actual = " + montoDepositar + " WHERE numero_cuenta = " +
                    this.numero_cuenta;

            try {
                connection = Conexion.conectar();
                statement = connection.createStatement();
                statement.execute(sql);
            } catch (SQLException e) {
                System.err.println("Error: no se pudieron actualizar los datos");
                System.err.println("No se puede actualizar el saldo: " + montoDepositar);
            } catch (NullPointerException nullPointerException) {
                System.err.println("No se pudo generar el stament");
                nullPointerException.printStackTrace();
            }
        } else {
            return false;
        }

        this.saldo_actual = consultarSaldo();
        return true;
    }

    public boolean depositarSaldoDestino(double montoDepositar,int numero_cuenta) {

        if (montoDepositar > 0) {
            montoDepositar = consultarSaldo() + montoDepositar;
            Statement statement;
            Connection connection;

            String sql = "UPDATE cuentas SET saldo_actual = " + montoDepositar + " WHERE numero_cuenta = " +
                    numero_cuenta;

            try {
                connection = Conexion.conectar();
                statement = connection.createStatement();
                statement.execute(sql);
            } catch (SQLException e) {
                System.err.println("Error: no se pudieron actualizar los datos");
                System.err.println("No se puede actualizar el saldo: " + montoDepositar);
            } catch (NullPointerException nullPointerException) {
                System.err.println("No se pudo generar el stament");
                nullPointerException.printStackTrace();
            }
        } else {
            return false;
        }

        this.saldo_actual = consultarSaldo();
        return true;
    }

    @Override
    public boolean transferir(double montoTransferir, int numeroCuentaDestino) {
        double saldoCuentaDestino = consultarSaldoParaTransferir(numeroCuentaDestino);
        double saldoPosterior = saldo_actual - montoTransferir;

        if(saldoPosterior >= 0 && saldoCuentaDestino != -1){

            depositarSaldoDestino(montoTransferir,numeroCuentaDestino);
            retirarSaldo(montoTransferir);
            return true;
        }else{
            return false;
        }

    }

    public double getSaldoActual() {
        return this.saldo_actual;
    }

    public Propietario getPropietario() {
        return this.propietario;
    }

    public String getTipoCuenta() {return tipoCuenta;}
}
