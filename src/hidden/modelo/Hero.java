package hidden.modelo;

public class Hero {

	private String nome;
	private int custo;
	private int obtido;

	public Hero(String nome, int custo, int obtido) {
		this.nome = nome;
		this.custo = custo;
		this.obtido = obtido;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCusto() {
		return custo;
	}
	public void setCusto(int custo) {
		this.custo = custo;
	}
	public int getObtido() {
		return obtido;
	}
	public void setObtido(int obtido) {
		this.obtido = obtido;
	}
}
