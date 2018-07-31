package main;
import java.time.LocalDate;
import java.util.ArrayList;

public class Livro implements Subject {
	private ArrayList<Reserva> reservas;
	private ArrayList<Observer> observers;
	private ArrayList<Exemplar> exemplares;
	private String titulo;
	private String autor;
	private int codigo;
	private String anoPublicacao;
	private String editora;
	private String edicao;
	
	public Livro(String titulo, String autor, int codigo, String anoPublicacao, String editora, String edicao) {
		this.titulo = titulo;
		this.autor = autor;
		this.codigo = codigo;
		this.anoPublicacao = anoPublicacao;
		this.editora = editora;
		this.edicao = edicao;
		this.reservas = new ArrayList<Reserva>();
		this.observers = new ArrayList<Observer>();
		this.exemplares = new ArrayList<Exemplar>();
		Biblioteca.getInstancia().addLivro(this);
	}
		
	public int numeroDeExemplaresDisponiveis() {
		int contador = 0;
		for (int j = 0; j < exemplares.size(); j++) {	
			Exemplar exemplar = exemplares.get(j);
			if(exemplar.getStatus().equals("disponivel")) {
				contador++;;
			}
		}
		return contador;
	}
	
	public int temReserva(Usuario usuario) {
		for (int i = 0; i < reservas.size(); i++) {
			Reserva reserva = reservas.get(i);
			if(reserva.compareTo(this, usuario)) {
				return i;
			}
		}
		return -1;
	}
	
	public int getIndiceExemplarDisponivel() {
		for (int j = 0; j < exemplares.size(); j++) {	
			Exemplar exemplar = exemplares.get(j);
			if(exemplar.getStatus().equals("disponivel")) {
				return j;
			}
		}
		return -1;
	}
	
	public Exemplar obterExemplarParaEmprestimo(int index) {
		Exemplar exemplar = exemplares.get(index);
		exemplar.setStatus("emprestado");
		return exemplar;
	}
	
	public void adicionarReserva(Reserva reserva) {
		reservas.add(reserva);
		if(getReservas().size() > 2) {
			notifyObservers();
		}
	}
	
	public void removerReserva(int index) {
		reservas.remove(index);
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
	
	public void printInfoLivro() {
	    System.out.println("Título: " + this.titulo);
        System.out.println("Quantidade de reservas: " + this.reservas.size());
	    if(!reservas.isEmpty()) {
	        System.out.println("Usuários que reservaram: ");
            reservas.forEach(r -> System.out.println(r.getUsuario().getNome()));
        }

	    if(!exemplares.isEmpty()) {
	        System.out.println("Exemplares");
	        exemplares.forEach(e -> System.out.println(e));
	    }
    }
	
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
		System.out.println("Observador adicionado");
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
			observer.update();
		}
	}

	/*Setters e Getters*/
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

	public String getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(String anoPublicacao) {
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
