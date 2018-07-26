package src;
import java.util.Date;

public class Emprestimo {
	private Exemplar exemplar;
	private Usuario usuario;
	private Date dataEmprestimo;
	private Date dataDevolucaoPrevista;
	private Date dataDevolucaoReal;
	
	public Emprestimo(Exemplar exemplar, Usuario usuario, Date dataEmprestimo, Date dataDevolucaoPrevista, Date dataDevolucaoReal) {
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
	
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	
	public Date getDataDevolucaoPrevista() {
		return dataDevolucaoPrevista;
	}
	
	public void setDataDevolucaoPrevista(Date dataDevolucaoPrevista) {
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}
	
	public Date getDataDevolucaoReal() {
		return dataDevolucaoReal;
	}
	
	public void setDataDevolucaoReal(Date dataDevolucaoReal) {
		this.dataDevolucaoReal = dataDevolucaoReal;
	}
}
