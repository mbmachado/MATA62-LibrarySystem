package main;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Reserva {
	private LocalDate data;
	private Usuario usuario;
	private Livro livro;
	
	public Reserva(LocalDate data, Usuario usuario, Livro livro) {
		this.data = data;
		this.usuario = usuario;
		this.livro = livro;
	}
	
	public boolean compareTo(Livro livro, Usuario usuario) {
		if(this.livro.equals(livro) && this.usuario.equals(usuario)) {
			return true;
		}
		return false;
	}
	
	public String toString(){
	    return "Título: " + this.livro.getTitulo() +  ", Data da solicitação: "
                + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

	/*Setters e Getters*/
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
