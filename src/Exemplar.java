
public class Exemplar {
	private final int ID;
	private Livro livro;
	private String status;
	
	public Exemplar(int ID, Livro livro, String status) {
		this.ID = ID;
		this.livro = livro;
		this.status = status;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getID() {
		return ID;
	}
}
