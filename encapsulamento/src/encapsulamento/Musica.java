package encapsulamento;

public class Musica {
	private String titulo;
	private String artista;
	private String genero;
	private String anoLancamento;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public void todar() {
		System.out.println("A música é : " + titulo + " de " + artista);
	}

	@Override
	public String toString() {
		return "A música tem o titulo=" + titulo + ", artista=" + artista + ", ano de lançamento:" + anoLancamento;
	}

}
