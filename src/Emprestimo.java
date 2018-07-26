package src;
import java.time.LocalDate;
import java.util.Date;

public class Emprestimo {
	private Exemplar exemplar;
	private Usuario usuario;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucaoPrevista;
	private LocalDate dataDevolucaoReal;
	
	public Emprestimo(Exemplar exemplar, Usuario usuario, LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista, LocalDate dataDevolucaoReal) {
		this.exemplar = exemplar;
		this.usuario = usuario;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
		this.dataDevolucaoReal = dataDevolucaoReal;
	}
	
	public Exemplar getExemplar() {
		return exemplar;
	}
	
	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	
	public Date getDataDevolucaoPrevista() {
	    return new Date();
        // TODO remover comentário depois de adaptar o método na classe Usuário
	    //return dataDevolucaoPrevista;
	}
	
	public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}
	
	public LocalDate getDataDevolucaoReal() {
		return dataDevolucaoReal;
	}
	
	public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
		this.dataDevolucaoReal = dataDevolucaoReal;
	}
}
