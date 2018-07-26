package main;
import java.util.ArrayList;

public class PosGraduacao extends Usuario {
	private final int tempoDeEmprestimo = 4;
	private final int limiteEmprestimos = 4;
	
	public PosGraduacao(String nome, int codigo) {
		super(nome, codigo);
		this.ce = new EmprestimoAluno();
		this.emprestimos = new ArrayList<Emprestimo>(limiteEmprestimos);
	}
	
	public int getTempoDeEmprestimo() {
		return tempoDeEmprestimo;
	}
	
	public int getLimiteEmprestimos() {
		return limiteEmprestimos;
	}
}
