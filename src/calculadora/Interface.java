package calculadora;

import java.util.Scanner;

public class Interface {
	private double valor1, valor2;
    public void calc(){
    Scanner s = new Scanner(System.in);
        System.out.println("Digite o valor1:");
        valor1 = s.nextDouble();
        String resumo =  "" + valor1;
        System.out.println("Digite o simbolo da operacao: ");
        char operador = s.next().charAt(0);
        while(operador!='='){
            Operacao o;
            switch(operador){
                case '+' -> {
                    resumo = defOperacaoSimples(resumo,true,s,operador);
                    o = new Soma(valor1 ,valor2);
                }
                case '-' -> {
                    resumo = defOperacaoSimples(resumo,true,s,operador);
                    o = new Subtracao(valor1 ,valor2);
                }
                case '*' -> {
                    resumo = defOperacaoSimples(resumo,false,s,operador);
                    o = new Multiplicacao(valor1 ,valor2);
                }
                case '/' -> {
                    resumo = defOperacaoSimples(resumo,false,s,operador);
                    o = new Divisao(valor1 ,valor2);
                }
                default -> {
                	System.out.println("Operacao invalida.");
                	System.out.println("Digite o simbolo da operacao: ");
                    operador = s.next().charAt(0);
                    continue;
                }
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
}
