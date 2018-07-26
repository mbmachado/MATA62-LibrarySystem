package src;

public class PosGraduacao extends Usuario {
	private final int tempoDeEmprestimo = 4;
	private final int limiteEmprestimos = 4;
	
	public PosGraduacao(String nome, int codigo) {
		super(nome, codigo);
		this.ce = new EmprestimoAluno();
	}
}