package calculadora;

public class Resto implements Operacao {
	private double valor1,valor2;
	public Resto(double valor1,double valor2) {
		this.valor1 = valor1;
		this.valor2 = valor2;
	}
	@Override
	public double executarOperacao() {
		return valor2!=0 ? valor1%valor2 : valor2;
	}

}
