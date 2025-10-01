package problema;

public class Livro implements Imprestavel {

	// inicializando variaveis
	private int codig;
	private String title;
	private String autor;
	private StatusLivro status;

	// metodos de acesso - contrutores e getter e setter
	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public Livro(int codig, String title, String autor, StatusLivro status) {
		this.codig = codig;
		this.title = title;
		this.autor = autor;
		this.status = status;
	}

	public int getCodig() {
		return codig;
	}

	public void setCodig(int codig) {
		this.codig = codig;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public StatusLivro getStatus() {
		return status;
	}

	public void setStatus(StatusLivro status) {
		this.status = status;
	}

	//metodo emprestar
	public void emprestar(Usuario u) throws Exception {
		if (status == StatusLivro.EMPRESTADO) {
			throw new Exception("Livro indisponível para empréstimo.");
		} else {
			status = StatusLivro.EMPRESTADO;
			System.out.println("O livro foi emprestado. Boa leitura!");
		}
	}
	
	//metodo devolver
	public void devolver() {
		System.out.println("O livro foi devolvido. Obrigado!");
		status = StatusLivro.DISPONIVEL;
	}

}
