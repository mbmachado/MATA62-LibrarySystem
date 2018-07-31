package main;
import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Usuario {
	protected ArrayList<Reserva> reservas;
	protected ArrayList<Emprestimo> emprestimos;
	protected ArrayList<Emprestimo> historico;
	protected String nome;
	protected int codigo;
	protected ComportamentoEmprestar ce;
	protected final int MAX_RESERVAS = 3;

	public Usuario(String nome, int codigo) {
		this.nome = nome;
		this.codigo = codigo;
		this.reservas = new ArrayList<Reserva>();
		this.emprestimos = new ArrayList<Emprestimo>();
		this.historico = new ArrayList<Emprestimo>();
		Biblioteca.getInstancia().addUsuario(this);
	}
	

	public void fazerEmprestimo(Livro livro) {
		ce.fazerEmprestimo(livro, this);
	}
	
	public void removerEmprestimo(Emprestimo emprestimo) {
		int i = emprestimos.indexOf(emprestimo);
		if (i >= 0) {
			emprestimos.remove(i);
		}
	}
	
	public void adicionarEmprestimo(Emprestimo emprestimo) {
		emprestimos.add(emprestimo);
	}
	
	public void adicionarHistorico(Emprestimo emprestimo) {
		historico.add(emprestimo);
	}
	
	public int numeroEmprestimosAtivos() {
		return emprestimos.size();
	}
	
	public boolean possuiEmprestimo(Livro livro) {
		boolean emprestado = false;
		
		for (int i = 0; i < emprestimos.size(); i++) {
            Emprestimo emprestimo = emprestimos.get(i);
            if (emprestimo.getExemplar().getLivro().equals(livro)) {
                emprestado = true;
                break;
            }
        }
        return emprestado;
	}
	
	public int numeroEmprestimosEmAtraso() {
		LocalDate today = LocalDate.now();
		int contador = 0;
		for (int i = 0; i < emprestimos.size(); i++) {
			Emprestimo emprestimoAtrasado = emprestimos.get(i);
			if(emprestimoAtrasado.getDataDevolucaoPrevista().isBefore(today) && emprestimoAtrasado.getDataDevolucaoReal() == null) {
				contador++;
			}
		}
		return contador;
	}
	
	public void fazerReserva(Livro livro) {
		if (reservas.size() < MAX_RESERVAS) {
			if(reservas.stream().filter(r -> r.compareTo(livro, this)).findAny().orElse(null) != null) {
				System.out.println("Não foi possível reservar, pois o livro já foi reservado!");
			} else if(emprestimos.stream().filter(e -> e.getExemplar().getLivro().equals(livro)).findAny().orElse(null) != null) {
				System.out.println("Não foi possível reservar, pois o livro já está emprestado!");
            } else {
            	if (livro.getReservas().size() < livro.numeroDeExemplaresDisponiveis()) {
	            	LocalDate data = LocalDate.now();
	                Reserva reserva = new Reserva(data, this, livro);
	            	this.adicionarReserva(reserva);
	            	livro.adicionarReserva(reserva);
	            	System.out.println("Reserva criada com sucesso!");
            	} else {
            		System.out.println("Não foi possível reservar, todos os exemplares foram reservados");
            	}
            }
        } else {
            System.out.println("Não foi possível reservar, pois o limite de reservas foi atingido!");
        }
    }

	public void fazerDevolucao(Livro livro) {

		if(this.possuiEmprestimo(livro)) {
			for (int i = 0; i < emprestimos.size(); i++) {
	            Emprestimo emprestimo = emprestimos.get(i);
	            if(emprestimo.tentarDevolver(livro)) {
	            	this.removerEmprestimo(emprestimo);
	            	this.adicionarHistorico(emprestimo);
	                break;
	            }
	        }
			System.out.println("Exemplar do livro devolvido!");
		} else {
			System.out.println("Não foi possível devolver, pois nunhum exemplar do livro foi emprestado!");
		}
	}
	
	public void printInfoUsuario() {
		
		System.out.println("Usuário: "+nome);
		if(!emprestimos.isEmpty()) {
			System.out.println("Emprestimos Ativos");
			emprestimos.forEach(a -> System.out.println(a));
		} else {
			System.out.println("Usuário sem emprestimos ativos!");
		}
		if(!historico.isEmpty()) {
			System.out.println("Históricos de Emprestimos");
			historico.forEach(h -> System.out.println(h));
		} else {
			System.out.println("Usuário sem histórico!");
		}
		if(!reservas.isEmpty()) {
			System.out.println("Reservas");
			reservas.forEach(r -> System.out.println(r));
		} else {
			System.out.println("Usuário sem reservas!");
		}
    }
	
	public void removerReserva(int index) {
		reservas.remove(index);
	}
	
	public void adicionarReserva(Reserva reserva) {
		reservas.add(reserva);
	}

	/*Setters e Getters*/
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public ComportamentoEmprestar getCe() {
		return ce;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public ArrayList<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public abstract int getTempoDeEmprestimo();
	public abstract int getLimiteEmprestimos();

}
