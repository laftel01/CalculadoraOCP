package calculadora;

import java.util.Scanner;

public class InterfaceExtendida extends Interface {
	@Override
	public Operacao switchOperacoes(char operador, Scanner s){
		switch(operador){
			case '*' -> {
				resumo = defOperacaoSimples(resumo,true,s,operador);
				return new Multiplicacao(valor1 ,valor2);
			}
			case '/' -> {
				resumo = defOperacaoSimples(resumo,true,s,operador);
				return new Divisao(valor1 ,valor2);
			}
			case '%' -> {
				resumo = defOperacaoSimples(resumo,true,s,operador);
				return new Resto(valor1 ,valor2);
			}
			default -> {
				return super.switchOperacoes(operador,s);
			}
		}
	}
}
