package Escritorio;

public class Arquivamento {

	static Processo inicio_fila2 = null;
	static Processo fim_fila2 = null;
	static int contFechados = 0;
	static int contFinanceiro = 0;
	static int contAdm = 0;
	static int contRH = 0;
	
	public static boolean filaArquivamentoVazia() {
		if(inicio_fila2 == null)
			return true;
		return false;
	}
	
	public static void arquivarProcesso(String fechar) {
		ManipulaProcessos.remover();
		switch(fechar) {
			case "Financeiro":
				contFechados += 1;
				ManipulaProcessos.contP1 -= 1;
				contFinanceiro += 1;
				
				if(filaArquivamentoVazia())
					inicio_fila2 = ManipulaProcessos.topoPilha1;
				else
					fim_fila2.proximoFila2 = ManipulaProcessos.topoPilha1;
				fim_fila2 = ManipulaProcessos.topoPilha1;
				break;
			case "Administrativo":
				contFechados += 1;
				ManipulaProcessos.contP2 -= 1;
				contAdm += 1;
				
				if(filaArquivamentoVazia())
					inicio_fila2 = ManipulaProcessos.topoPilha2;
				else
					fim_fila2.proximoFila2 = ManipulaProcessos.topoPilha2;
				fim_fila2 = ManipulaProcessos.topoPilha2;
				break;
			case "Recursos Humanos":
				contFechados += 1;
				ManipulaProcessos.contP3 -= 1;
				contRH += 1;
				
				if(filaArquivamentoVazia())
					inicio_fila2 = ManipulaProcessos.topoPilha3;
				else
					fim_fila2.proximoFila2 = ManipulaProcessos.topoPilha3;
				fim_fila2 = ManipulaProcessos.topoPilha3;
				break;
			default:
				break;
		}
	}
}
