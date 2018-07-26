
public class Professor extends Usuario implements Observer {
	private final int tempoDeEmprestimo = 7;
	private final int limiteEmprestimos = Integer.MAX_VALUE;
	
	public Professor(String nome, int codigo) {
		super(nome, codigo);
		this.ce = new EmprestimoAluno();
	}
	
	public int getTempoDeEmprestimo() {
		return tempoDeEmprestimo;
	}
	
	public int getLimiteEmprestimos() {
		return limiteEmprestimos;
	}
	
	@Override
	public void update(Subject livro) {
		// TODO Auto-generated method stub

	}

}
