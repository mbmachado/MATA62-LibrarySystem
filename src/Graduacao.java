
public class Graduacao extends Usuario {
	private final int tempoDeEmprestimo = 3;
	private final int limiteEmprestimos = 3;
	
	public Graduacao(String nome, int codigo) {
		super(nome, codigo);
		this.ce = new EmprestimoAluno();
	}

	public int getTempoDeEmprestimo() {
		return tempoDeEmprestimo;
	}
	
	public int getLimiteEmprestimos() {
		return limiteEmprestimos;
	}
}
