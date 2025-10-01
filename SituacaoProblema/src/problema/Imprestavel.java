package problema;

public interface Imprestavel {
	//interface emprestar com excecao de quando o livro não pode emprestar
	void emprestar(Usuario u) throws Exception;
	void devolver();
}
