package Escritorio;

public class ManipulaProcessos {

	static Processo inicio_fila = null;
	static Processo fim_fila = null;
	static int contAnalise = 0;
	static int funcionarios = 10;
	static int filaArq = 0;
	
	static Processo topoPilha1 = null;
	static Processo topoPilha2 = null;
	static Processo topoPilha3 = null;
	static int contP1 = 0;
	static int contP2 = 0;
	static int contP3 = 0;
	
	//verificação de fila e pilha vazia
	public static boolean filaProcessoVazia() {
		if(inicio_fila == null)
			return true;
		return false;
	}
	
	public static boolean pilha1ProcessoVazia() {
		if(topoPilha1 == null)
			return true;
		return false;
	}
	
	public static boolean pilha2ProcessoVazia() {
		if(topoPilha2 == null)
			return true;
		return false;
	}
	
	public static boolean pilha3ProcessoVazia() {
		if(topoPilha3 == null)
			return true;
		return false;
	}
	
	//manipulacao da fila
	public static void inserirProcesso(Processo novo) {
		contAnalise += 1;
		if(filaProcessoVazia())
			inicio_fila = novo;
		else
			fim_fila.proximoFila = novo;
		fim_fila = novo;
	}
	
	public static void remover() {
		contAnalise -= 1;
	}
	
	public static int funcionariosNaFila() {
		return funcionarios - contAnalise;
	}
	
	
	//manipulação da pilha
	//pilha financeiro
	public static void inserirPilha1(Processo novo) {
		contP1 += 1;
		if(pilha1ProcessoVazia())
			topoPilha1 = novo;
		else
			novo.proximoPilha1 = topoPilha1;
		topoPilha1 = novo;
	}
		
	//pilha administrativo
	public static void inserirPilha2(Processo novo) {
		contP2 += 1;
		if(pilha2ProcessoVazia())
			topoPilha2 = novo;
		else {
			novo.proximoPilha2 = topoPilha2;
			topoPilha2 = novo;
		}
	}
		
	//pilha recursos humanos
	public static void inserirPilha3(Processo novo) {
		contP3 += 1;
		if(pilha3ProcessoVazia())
			topoPilha3 = novo;
		else
			novo.proximoPilha3 = topoPilha3;
		topoPilha3 = novo;
	}
		
	public static void separaProcesso() {
			
		switch(inicio_fila.tipo) {
			case "Financeiro":
				inserirPilha1(inicio_fila);
				break;
			case "Administrativo":
				inserirPilha2(inicio_fila);
				break;
			case "Recursos Humanos":
				inserirPilha3(inicio_fila);
				break;
			default:
				System.out.println("Tipo de processo inválido");
				break;
		}
		inicio_fila = inicio_fila.proximoFila;
	}
	
	//metodo para o funcionario pegar um processo
	public static void funcionarioPegaPilha(String tipoProcesso) {
		
		boolean confirmado = false;
		
		while(!confirmado) {
			switch(tipoProcesso) {
				case "Financeiro":
					if(pilha1ProcessoVazia() == false) {
						Funcionario.processo = topoPilha1;
						confirmado = true;
					}
					break;
				case "Administrativo":
					if(pilha2ProcessoVazia() == false) {
						Funcionario.processo = topoPilha2;
						confirmado = true;
					}
					break;
				case "Recursos Humanos":
					if(pilha3ProcessoVazia() == false) {
						Funcionario.processo = topoPilha3;
						confirmado = true;
					}
					break;
				default:
					break;
			}
			filaArq += 1;
		}
	}
}
