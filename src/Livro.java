import java.util.ArrayList;
import java.util.Date;

public class Livro implements Subject {
	private ArrayList<Reserva> reservas;
	private ArrayList<Observer> observers;
	private ArrayList<Exemplar> exemplares;
	private String titulo;
	private String autor;
	private int codigo;
	private Date anoPublicacao;
	private String editora;
	private String edicao;
	
	public Livro(String titulo, String autor, int codigo, Date anoPublicacao, String editora, String edicao) {
		this.titulo = titulo;
		this.autor = autor;
		this.codigo = codigo;
		this.anoPublicacao = anoPublicacao;
		this.editora = editora;
		this.edicao = edicao;
	}
	
	public void adicionarReserva(Reserva reserva) {
		reservas.add(reserva);
	}
	
	public void removerReserva(Reserva reserva) {
		int i = reservas.indexOf(reserva);
		if (i >= 0) {
			reservas.remove(i);
		}
	}
	
	public void adicionarExemplar(Exemplar exemplar) {
		exemplares.add(exemplar);
	}
	
	public void removerExemplar(Exemplar exemplar) {
		int i = exemplares.indexOf(exemplar);
		if (i >= 0) {
			exemplares.remove(i);
		}
	}
	
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);

	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = observers.get(i);
			observer.update(this);
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(Date anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public ArrayList<Exemplar> getExemplares() {
		return exemplares;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}

}
