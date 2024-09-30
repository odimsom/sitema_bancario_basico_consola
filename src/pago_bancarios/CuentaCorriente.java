package pago_bancarios;

public class CuentaCorriente extends CuentaBancaria {
    public static final double LIMITE_DESCUBIERTO = 500.0;

    	
    public CuentaCorriente(double saldo, String numeroDeCuenta, String nombreDelTitular) {
        super(saldo, numeroDeCuenta, nombreDelTitular);
    }
    
    @Override
    public void retirar(double cantidad) {
        if (getSaldo() + LIMITE_DESCUBIERTO >= cantidad) {
            setSaldo(getSaldo() - cantidad);
            System.out.println("Retiro exitoso. Nuevo saldo: " + getSaldo());
        } else {
            System.out.println("Fondos insuficientes, incluyendo el límite de descubierto.");
        }
    }

    @Override
    public void depositar(double cantidad) {
        setSaldo(getSaldo() + cantidad);
        System.out.println("Depósito exitoso. Nuevo saldo: " + getSaldo());
    }
}
