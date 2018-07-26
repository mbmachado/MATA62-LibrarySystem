import java.util.ArrayList;
import java.util.Date;

public abstract class Usuario {
	protected ArrayList<Reserva> reservas;
	protected ArrayList<Emprestimo> emprestimos;
	protected String nome;
	protected int codigo;
	protected ComportamentoEmprestar ce;
	
	public Usuario(String nome, int codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}
	
	public void fazerEmprestimo() {
		ce.fazerEmprestimo();
	}
	
	public void fazerDevolucao(Emprestimo emprestimo) {
		int i = emprestimos.indexOf(emprestimo);
		if(emprestimos.get(i).getDataDevolucaoReal() == null) {
			emprestimos.get(i).setDataDevolucaoPrevista(new Date());
		}
	}
	
	public Reserva fazerReserva(Livro livro, Date data) {
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
	
	public ArrayList<Emprestimo> obterEmprestimosEmAtraso() {
		ArrayList<Emprestimo> emprestimosEmAtraso = new ArrayList();
		Date today = new Date();
		for (int i = 0; i < emprestimos.size(); i++) {
			Emprestimo emprestimoAtrasado = emprestimos.get(i);
			if(emprestimoAtrasado.getDataDevolucaoPrevista().before(today)) {
				emprestimosEmAtraso.add(emprestimoAtrasado);
			}
		}
		return emprestimosEmAtraso;
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
}
