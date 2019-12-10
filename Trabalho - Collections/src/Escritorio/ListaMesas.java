package Escritorio;

public class ListaMesas {

	public static Mesa inicioLista = null;
	public static Mesa fimLista = null;
	public static int contAnalise = 0;
	
	public static void inserirMesa(int numero) {
		contAnalise += 1;
		Mesa novo = new Mesa();
		novo.numero = numero;
		if(contAnalise < 5) {
			if(inicioLista == null) {
				inicioLista = novo;
			}else {
				fimLista.proximo = novo;
			}
			fimLista = novo;
		}
	}
	
	public static int mesasLivres() {
		return 5 - contAnalise;
	}
	
	public static boolean verificaMesaLivre() {
		if(mesasLivres() == 0) {
			return false; 
		}
		return true; 
	}
	public static void funcionarioPegaMesa() {
		if(verificaMesaLivre()) {
			Funcionario.mesa = inicioLista;
			contAnalise += 1;
		} else {
			System.out.println("Todas as mesas estão ocupadas");
		}
	}
}
