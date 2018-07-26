import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Usuario {
	protected ArrayList<Reserva> reservas;
	protected ArrayList<Emprestimo> emprestimos;
	protected String nome;
	protected int codigo;
	protected ComportamentoEmprestar ce;
	
	public Usuario(String nome, int codigo) {
		this.nome = nome;
		this.codigo = codigo;
		this.emprestimos = new ArrayList<Emprestimo>();
		this.reservas = new ArrayList<Reserva>();
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
	
	public boolean jaPossuiEmprestimo(Exemplar exemplar) {
		boolean emprestado = false;
		for (int i = 0; i < emprestimos.size(); i++) {
			Emprestimo emprestimo = emprestimos.get(i);
			if(emprestimo.jaRealizado(exemplar)) {
				emprestado = true;
				break;
			}
		}
		return emprestado;
	}
	
	public ArrayList<Emprestimo> obterEmprestimosEmAtraso() {
		ArrayList<Emprestimo> emprestimosEmAtraso = new ArrayList<Emprestimo>();
		LocalDate today = LocalDate.now();
		for (int i = 0; i < emprestimos.size(); i++) {
			Emprestimo emprestimoAtrasado = emprestimos.get(i);
			if(emprestimoAtrasado.getDataDevolucaoPrevista().isBefore(today)) {
				emprestimosEmAtraso.add(emprestimoAtrasado);
			}
		}
		return emprestimosEmAtraso;
	}
	
	public int numeroEmprestimosEmAtraso() {
		LocalDate today = LocalDate.now();
		int contador = 0;
		for (int i = 0; i < emprestimos.size(); i++) {
			Emprestimo emprestimoAtrasado = emprestimos.get(i);
			if(emprestimoAtrasado.getDataDevolucaoPrevista().isBefore(today)) {
				contador++;
			}
		}
		return contador;
	}
	
	public Reserva fazerReserva(Livro livro, LocalDate data) {
		return new Reserva(data, this, livro);
	}
	
	public void removerReserva(Reserva reserva) {
		int i = reservas.indexOf(reserva);
		if (i >= 0) {
			reservas.remove(i);
		}
	}
	
	public void adicionarReserva(Reserva reserva) {
		reservas.add(reserva);
	}
	
	public void fazerDevolucao(Emprestimo emprestimo) {
		int i = emprestimos.indexOf(emprestimo);
		if(emprestimos.get(i).getDataDevolucaoReal() == null) {
			emprestimos.get(i).setDataDevolucaoReal(LocalDate.now());
		}
	}

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
