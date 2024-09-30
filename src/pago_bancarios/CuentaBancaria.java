package pago_bancarios;

public abstract class CuentaBancaria implements IMovimientos {
    private double saldo;
    private String numeroDeCuenta;
    private String nombreDelTitular;
    
    

    protected double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public String getNombreDelTitular() {
        return nombreDelTitular;
    }

    public void setNombreDelTitular(String nombreDelTitular) {
        this.nombreDelTitular = nombreDelTitular;
    }
    

    public CuentaBancaria(double saldo, String numeroDeCuenta, String nombreDelTitular) {
        this.saldo = saldo;
        this.numeroDeCuenta = numeroDeCuenta;
        this.nombreDelTitular = nombreDelTitular;
    }
}
