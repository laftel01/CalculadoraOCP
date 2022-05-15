package calculadora;

public class Multiplicacao implements Operacao {
	private double valor1, valor2;
	public Multiplicacao(double valor1,double valor2) {
		this.valor1 = valor1;
		this.valor2 = valor2;
	}
	@Override
	public double executarOperacao() {
		return valor1 * valor2;
	}

}
