package pago_bancarios;

import java.util.*;

public class Banco {
    static Scanner scan = new Scanner(System.in);
    
    private List<CuentaBancaria> cuentas;

    public Banco() {
        this.cuentas = new ArrayList<>();
    }

    public void agregarCuenta(CuentaBancaria nuevaCuenta) {
        cuentas.add(nuevaCuenta);
        System.out.println("Cuenta agregada: " + nuevaCuenta.getNumeroDeCuenta());
    }

    public void eliminarCuenta(String numeroDeCuenta) {
        Iterator<CuentaBancaria> iterator = cuentas.iterator();
        while (iterator.hasNext()) {
            CuentaBancaria cuenta = iterator.next();
            if (cuenta.getNumeroDeCuenta().equals(numeroDeCuenta)) {
                iterator.remove();
                System.out.println("Cuenta eliminada: " + numeroDeCuenta);
                return;
            }
        }
        System.out.println("Cuenta no encontrada.");
    }

    public void mostrarInformacion() {
        for (CuentaBancaria cuenta : cuentas) {
            System.out.println("Número de Cuenta: " + cuenta.getNumeroDeCuenta());
            System.out.println("Titular: " + cuenta.getNombreDelTitular());
            System.out.println("Saldo: " + cuenta.getSaldo());
            System.out.println("--------------------------");
        }
    }
    

    public void menu() {
        int opcion;
        do {
            System.out.println("---- Menú del Banco ----");
            System.out.println("1. Agregar Cuenta");
            System.out.println("2. Eliminar Cuenta");
            System.out.println("3. Mostrar Información de Cuentas");
            System.out.println("4. Depositar");
            System.out.println("5. Retirar");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    agregarNuevaCuenta();
                    break;
                case 2:
                    System.out.print("Ingrese el número de cuenta a eliminar: ");
                    String numeroCuentaEliminar = scan.next();
                    eliminarCuenta(numeroCuentaEliminar);
                    break;
                case 3:
                    mostrarInformacion();
                    break;
                case 4:
                    realizarDeposito();
                    break;
                case 5:
                    realizarRetiro();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 6);
    }

    private void agregarNuevaCuenta() {
        System.out.println("Seleccione el tipo de cuenta:");
        System.out.println("1. Cuenta de Ahorros");
        System.out.println("2. Cuenta Corriente");
        int tipoCuenta = scan.nextInt();

        System.out.print("Ingrese el saldo inicial: ");
        double saldo = scan.nextDouble();
        System.out.print("Ingrese el número de cuenta: ");
        String numeroDeCuenta = scan.next();
        System.out.print("Ingrese el nombre del titular: ");
        String nombreDelTitular = scan.next();

        if (tipoCuenta == 1) {
            CuentaDeAhorros nuevaCuenta = new CuentaDeAhorros(saldo, numeroDeCuenta, nombreDelTitular);
            agregarCuenta(nuevaCuenta);
        } else if (tipoCuenta == 2) {
            CuentaCorriente nuevaCuenta = new CuentaCorriente(saldo, numeroDeCuenta, nombreDelTitular);
            agregarCuenta(nuevaCuenta);
        } else {
            System.out.println("Tipo de cuenta no válido.");
        }
    }

    private void realizarDeposito() {
        System.out.print("Ingrese el número de cuenta para depositar: ");
        String numeroCuenta = scan.next();
        System.out.print("Ingrese la cantidad a depositar: ");
        double cantidad = scan.nextDouble();

        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroDeCuenta().equals(numeroCuenta)) {
                cuenta.depositar(cantidad); 
                return;
            }
        }
        System.out.println("Cuenta no encontrada.");
    }

    private void realizarRetiro() {
        System.out.print("Ingrese el número de cuenta para retirar: ");
        String numeroCuenta = scan.next();
        System.out.print("Ingrese la cantidad a retirar: ");
        double cantidad = scan.nextDouble();

        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroDeCuenta().equals(numeroCuenta)) {
                cuenta.retirar(cantidad); 
                return;
            }
        }
        System.out.println("Cuenta no encontrada.");
    }
}
