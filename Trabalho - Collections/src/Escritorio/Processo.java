package Escritorio;

public class Processo {

	String tipo;
	String nome;
	Processo proximoFila;
	Processo proximoFila2;
	Processo proximoPilha1;
	Processo proximoPilha2;
	Processo proximoPilha3;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		if(tipo.length() > 0)
			this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome.length() > 0)
			this.nome = nome;
	}	
}
