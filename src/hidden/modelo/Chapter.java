package hidden.modelo;

public class Chapter {
	
	private int numero;
	private String heroiRequerido;
	
	public Chapter(int numero, String heroiRequerido) {
		this.numero = numero;
		this.heroiRequerido = heroiRequerido;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getHeroiRequerido() {
		return heroiRequerido;
	}

	public void setHeroiRequerido(String heroiRequerido) {
		this.heroiRequerido = heroiRequerido;
	}
	
}
