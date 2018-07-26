package src;

public class Professor extends Usuario implements Observer {
	private final int tempoDeEmprestimo = 7;
	private final int limiteEmprestimos = Integer.MAX_VALUE;
	private int qtdNotificacoes;
	
	public Professor(String nome, int codigo) {
		super(nome, codigo);
		this.ce = new EmprestimoAluno();
		this.qtdNotificacoes = 0;
	}
	
	public int getTempoDeEmprestimo() {
		return tempoDeEmprestimo;
	}
	
	public int getLimiteEmprestimos() {
		return limiteEmprestimos;
	}
	
	public int getQtdNotificacoes() {
		return qtdNotificacoes;
	}

	public void setQtdNotificacoes(int qtdNotificacoes) {
		this.qtdNotificacoes = qtdNotificacoes;
	}

	@Override
	public void update() {
		qtdNotificacoes++;
	}

	public void qtdNotificacoes() {

    }

}
