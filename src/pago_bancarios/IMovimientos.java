package pago_bancarios;

public interface IMovimientos {
	/**
	 * sera la cantidad para depositar	
	 * @param cantidad
	 */
	void depositar(double cantidad);
	
	/**
	 * sera la cantida para retirar
	 * @param cantidad
	 */
	void retirar(double cantidad);

}
