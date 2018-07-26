package src;
import java.time.LocalDate;


public class Reserva {
	private LocalDate data;
	private Usuario usuario;
	private Livro livro;
	
	public Reserva(LocalDate data, Usuario usuario, Livro livro) {
		this.data = data;
		this.usuario = usuario;
		this.livro = livro;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
}
