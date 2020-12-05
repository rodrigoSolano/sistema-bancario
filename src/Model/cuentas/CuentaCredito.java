// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com
package Model.cuentas;

public class CuentaCredito extends Cuenta{

    int lineaCredito;
    int intereses;

    public CuentaCredito(Propietario cliente, int numeroCuenta, int saldo, String tipoCuenta, int lineaCredito, int intereses) {
        super(cliente, numeroCuenta, saldo, tipoCuenta);
        this.lineaCredito = lineaCredito;
        this.intereses = intereses;
    }

    public CuentaCredito(Propietario propietario, int numeroCuenta, int saldo, int id_cliente) {
        super(propietario, numeroCuenta, saldo, "credito", id_cliente);
    }
}
