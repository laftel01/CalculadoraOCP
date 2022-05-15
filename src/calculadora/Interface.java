package calculadora;

import java.util.Scanner;

public class Interface {
	public double valor1, valor2;
	public String resumo;
    public void calc(){
    Scanner s = new Scanner(System.in);
        System.out.println("Digite o valor1:");
        valor1 = s.nextDouble();
        resumo =  "" + valor1;
        System.out.println("Digite o simbolo da operacao: ");
        char operador = s.next().charAt(0);
        while(operador!='='){
            Operacao o = switchOperacoes(operador,s);
			if(o==null) {
				System.out.println("Operacao invalida.");
				System.out.println("Digite o simbolo da operacao: ");
				operador = s.next().charAt(0);
				continue;
			}
            valor1 = o.executarOperacao();
            System.out.println("Digite o simbolo da operacao: ");
            operador = s.next().charAt(0);
        }
        System.out.println("O resultado da operacao " + resumo + " eh: "+ valor1);
        s.close();
    }
    
    public String defOperacaoSimples(String resumo, boolean parentesis, Scanner s, char operador) {
    	System.out.println("Digite o valor2:");
        valor2 = s.nextDouble();
        String retorno = resumo + operador + valor2;
        return parentesis ? "(" + retorno + ")" : retorno;
    }
    
	public Operacao switchOperacoes(char operador, Scanner s){
		switch(operador){
			case '+' -> {
				resumo = defOperacaoSimples(resumo,true,s,operador);
				return new Soma(valor1 ,valor2);
			}
			case '-' -> {
				resumo = defOperacaoSimples(resumo,true,s,operador);
				return new Subtracao(valor1 ,valor2);
			}
			case '*' -> {
				resumo = defOperacaoSimples(resumo,false,s,operador);
				return new Multiplicacao(valor1 ,valor2);
			}
			case '/' -> {
				resumo = defOperacaoSimples(resumo,false,s,operador);
				return new Divisao(valor1 ,valor2);
			}
			default -> {
				return null;
			}
		}
	}
}
