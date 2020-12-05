// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com
package Model.cuentas;

import java.util.ArrayList;

public class CuentaDebito extends Cuenta {

    public ArrayList<String> acciones = new ArrayList<>();

    public CuentaDebito(Propietario propietario, int numeroCuenta, int saldo, int id_cliente) {
        super(propietario, numeroCuenta, saldo, "debito", id_cliente);
        acciones.add("Consultar saldo");
        acciones.add("Depositar");
        acciones.add("Retirar");
        acciones.add("Salir");
    }

}
