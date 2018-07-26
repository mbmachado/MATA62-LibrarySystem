package main;
import java.util.ArrayList;

public class Exemplar {
	private ArrayList<Emprestimo> emprestimos;
	private final int ID;
	private Livro livro;
	private String status;
	
	public Exemplar(int ID, Livro livro) {
		this.ID = ID;
		this.livro = livro;
		this.status = "disponivel";
		this.emprestimos = new ArrayList<Emprestimo>();
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

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getID() {
		return ID;
	}

    public String toString() {
	    return "Código do livro: " + this.livro.getCodigo() + ", Código do Exemplar: " + this.ID + ", Status: "
                + this.status;
    }
}
