package Escritorio;

public class Funcionario {

	static String nome;
	static String cpf;
	static Processo processo;
	static Mesa mesa;
	
	public static String getNome() {
		return nome;
	}
	public static void setNome(String nome) {
		Funcionario.nome = nome;
	}
	public static String getCpf() {
		return cpf;
	}
	public static void setCpf(String cpf) {
		Funcionario.cpf = cpf;
	}
}
