package Escritorio;

import java.util.Scanner;

public class Menu {

public static void menu() {
		
		Scanner entrada = new Scanner(System.in);
		
		int op = 0;
		do {
			System.out.println("=== Menu ===");
			System.out.println("1 - Inserir Processo");
			System.out.println("2 - Colocar processo na pilha");
			System.out.println("3 - Funcionario pega processo");
			System.out.println("4 - Escolher mesa");
			System.out.println("5 - Fechamento do processo");
			System.out.println("6 - Total de processos fechados");
			System.out.println("7 - Estátisticas");
			System.out.println("0 - Sair");
			op = Integer.parseInt(entrada.nextLine());
			switch(op) {
				case 1: 
					Processo novo = new Processo();
					System.out.print("Informe o nome do processo: ");
					String nomeP = entrada.nextLine();
					novo.setNome(nomeP);
					System.out.print("Informe o tipo de processo(Financeiro, Administrativo ou Recursos Humanos: ");
					String tipoP = entrada.nextLine();
					novo.setTipo(tipoP);
					ManipulaProcessos.inserirProcesso(novo);
					break;
				case 2:
					ManipulaProcessos.separaProcesso();
					break;
				case 3:
					System.out.println("Escolha uma pilha de processos");
					System.out.println("- Financeiro");
					System.out.println("- Administrativo");
					System.out.println("- Recursos Humanos");
					String tipoProcesso = entrada.nextLine();
					ManipulaProcessos.funcionarioPegaPilha(tipoProcesso);
					break;
				case 4:
					ListaMesas.funcionarioPegaMesa();
					break;
				case 5:
					System.out.println("Informe o tipo de processo que deseja fechar");
					System.out.println("- Financeiro");
					System.out.println("- Administrativo");
					System.out.println("- Recursos Humanos");
					String fecharProcesso = entrada.nextLine();
					Arquivamento.arquivarProcesso(fecharProcesso);
					break;
				case 6:
					System.out.println(Arquivamento.contFechados);
					break;
				case 7:
					System.out.println("1- Funcionário na fila para analisar: " + ManipulaProcessos.funcionariosNaFila());
					System.out.println("2- Funcionário na fila de arquivamento: " + ManipulaProcessos.filaArq);
					System.out.println("3- Funcionário na fila analisando: " + ManipulaProcessos.contAnalise);
					System.out.println("4- Processos fechados: " + Arquivamento.contFechados);
					System.out.println("5- Processos financeiros fechados: " + Arquivamento.contFinanceiro);
					System.out.println("6- Processos administrativos fechados: " + Arquivamento.contAdm);
					System.out.println("7- Processos recursos humanos fechados: " + Arquivamento.contRH);
					System.out.println("8- Processos na pilha do financeiro: " + ManipulaProcessos.contP1);
					System.out.println("9- Processos na pilha do administrativo: " + ManipulaProcessos.contP2);
					System.out.println("10- Processos na pilha do recursos humanos: " + ManipulaProcessos.contP3);
					System.out.println("11- Mesas livres: " + ListaMesas.mesasLivres());
					break;
				case 0:
					System.out.println("Valeu falou");
					break;
				default:
					System.out.println("Opção inválida");
					break;
			}
		}while(op != 0);
		
		entrada.close();
	}
}
