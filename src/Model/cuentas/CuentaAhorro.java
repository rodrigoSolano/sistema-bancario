// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com
package Model.cuentas;

import javax.swing.*;

public class CuentaAhorro extends Cuenta {

	private int porcentajeGanancias;
	private int saldoAhorrado;


    public CuentaAhorro(Propietario propietario, int numeroCuenta, int saldo, int id_cliente) {
        super(propietario, numeroCuenta, saldo, "ahorro", id_cliente);
    }


    public double retirarSaldo(double saldo_retirar){
        JOptionPane.showConfirmDialog(null,"No se puede retirar dinero de una cuenta de ahorros","Error",JOptionPane.DEFAULT_OPTION);
        return -1;
    }


}
