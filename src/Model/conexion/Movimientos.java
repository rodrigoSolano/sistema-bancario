// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com
package Model.conexion;

public interface Movimientos {

    public double consultarSaldo();
    public double retirarSaldo(double saldo);
    public boolean depositarSaldo(double montoDepositar);
    public boolean transferir(double montoTransferir, int numeroCuenta);

}
