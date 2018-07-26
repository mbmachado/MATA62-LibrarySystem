import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Usuario {
	protected ArrayList<Reserva> reservas;
	protected ArrayList<Emprestimo> emprestimos;
	protected String nome;
	protected int codigo;
	protected ComportamentoEmprestar ce;
	protected final int MAX_RESERVAS = 3; 
	
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
	
	public int numeroEmprestimosAtivos() {
		int contador = 0;
		for (int i = 0; i < emprestimos.size(); i++) {
			Emprestimo emprestimo = emprestimos.get(i);
			if(emprestimo.getDataDevolucaoReal().equals(null)) {
				contador++;
			}
		}
		return contador;
	}
	
	public ArrayList<Emprestimo> obterEmprestimosAtivos() {
		ArrayList<Emprestimo> emprestimosAtivos = new ArrayList<Emprestimo>();
		for (int i = 0; i < emprestimos.size(); i++) {
			Emprestimo emprestimo = emprestimos.get(i);
			if(emprestimo.getDataDevolucaoReal().equals(null)) {
				emprestimosAtivos.add(emprestimo);
			}
		}
		return emprestimosAtivos;
	}
	
	public ArrayList<Emprestimo> obterEmprestimosPassados() {
		ArrayList<Emprestimo> emprestimosPassados = new ArrayList<Emprestimo>();
		for (int i = 0; i < emprestimos.size(); i++) {
			Emprestimo emprestimo = emprestimos.get(i);
			if(!emprestimo.getDataDevolucaoReal().equals(null)) {
				emprestimosPassados.add(emprestimo);
			}
		}
		return emprestimosPassados;
	}
	
	public ArrayList<Emprestimo> obterEmprestimosEmAtraso() {
		ArrayList<Emprestimo> emprestimosEmAtraso = new ArrayList<Emprestimo>();
		LocalDate today = LocalDate.now();
		for (int i = 0; i < emprestimos.size(); i++) {
			Emprestimo emprestimoAtrasado = emprestimos.get(i);
			if(emprestimoAtrasado.getDataDevolucaoPrevista().isBefore(today) && emprestimoAtrasado.getDataDevolucaoReal().equals(null)) {
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
			if(emprestimoAtrasado.getDataDevolucaoPrevista().isBefore(today) && emprestimoAtrasado.getDataDevolucaoReal().equals(null)) {
				contador++;
			}
		}
		return contador;
	}
	
	public void fazerReserva(Livro livro, LocalDate data) {
		if(reservas.size() <= MAX_RESERVAS) {
			Reserva reserva = new Reserva(data, this, livro);
			this.adicionarReserva(reserva);
			livro.adicionarReserva(reserva);
			System.out.println("Reserva criada com sucesso!");
		} else {
			System.out.println("Não foi possível reservar, pois o limite de reservas foi atingido!");
		}
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
	
	public void fazerDevolucao(Livro livro) {
		ArrayList<Exemplar> exemplares = livro.getExemplares();
		ArrayList<Emprestimo> emprestimosAtivos = this.obterEmprestimosAtivos();
		boolean devolvido = false;

		for (int i = 0; i < emprestimosAtivos.size(); i++) {
			Emprestimo emprestimo = emprestimos.get(i);
			for (int j = 0; j < exemplares.size(); j++) {
				Exemplar exemplar = exemplares.get(i);
				
				if(emprestimo.getExemplar().equals(exemplar)) {
					emprestimo.setDataDevolucaoReal(LocalDate.now());
					exemplar.setStatus("disponivel");
					devolvido = true;
					break;
				}
			}
		}
		if(devolvido) {
			System.out.println("Exemplar do livro devolvido!");
		} else {
			System.out.println("Não foi possível devolver, pois nunhum exemplar do livro foi emprestado!");
		}
	}
	
	public void informacoes() {
		ArrayList<Emprestimo> ativos = obterEmprestimosAtivos();
		ArrayList<Emprestimo> passados = obterEmprestimosPassados();
		
		System.out.println("Usuário: "+nome);
		if(!ativos.isEmpty()) {
			System.out.println("Emprestimos Ativos");
			System.out.println(ativos);
		}
		if(!passados.isEmpty()) {
			System.out.println("Emprestimos Passados");
			System.out.println(passados);
		}
		if(!reservas.isEmpty()) {
			System.out.println("Reservas");
			System.out.println(reservas);
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
