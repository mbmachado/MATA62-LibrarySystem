import java.util.Date;

public class Reserva {
	private Date data;
	private Usuario usuario;
	private Livro livro;
	
	public Reserva(Date data, Usuario usuario, Livro livro) {
		this.data = data;
		this.usuario = usuario;
		this.livro = livro;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
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
