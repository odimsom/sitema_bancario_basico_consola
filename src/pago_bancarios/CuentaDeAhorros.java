package pago_bancarios;

public class CuentaDeAhorros extends CuentaBancaria {
    public static final double TASA_INTERES_ANUAL = 0.02;

    public CuentaDeAhorros(double saldo, String numeroDeCuenta, String nombreDelTitular) {
        super(saldo, numeroDeCuenta, nombreDelTitular);
    }

    @Override
    public void depositar(double cantidad) {
        setSaldo(getSaldo() + cantidad);
        System.out.println("Depósito exitoso. Nuevo saldo: " + getSaldo());
    }

    @Override
    public void retirar(double cantidad) {
        if (cantidad <= getSaldo()) {
            setSaldo(getSaldo() - cantidad);
            System.out.println("Retiro exitoso. Nuevo saldo: " + getSaldo());
        } else {
            System.out.println("Fondos insuficientes para realizar el retiro.");
        }
    }

    public void calcularInteres() {
        double interes = getSaldo() * TASA_INTERES_ANUAL;
        System.out.println("Interés acumulado: " + interes);
    }
}
