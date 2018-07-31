package main;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	
	public boolean tentarDevolver(Livro livro) {
		if(this.getExemplar().getLivro().equals(livro)) {
			this.setDataDevolucaoReal(LocalDate.now());
            this.getExemplar().setStatus("disponivel");
            return true; 
		}
		return false;
	}
	
	public String toString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String dataDevolucao;

	    if(dataDevolucaoReal == null) {
            dataDevolucao = "Data devolução prevista: " + dataDevolucaoPrevista.format(dateFormat);
        } else {
	        dataDevolucao = "Data de devolução: " + dataDevolucaoReal.format(dateFormat);
        }

        String titulo = "Título: " + exemplar.getLivro().getTitulo();
	    String dataEmprestimo = ", Data do emprestimo: " + this.dataEmprestimo.format(dateFormat);
        String status = ", Status: " + exemplar.getStatus()+", ";

        return titulo + dataEmprestimo + status + dataDevolucao;
    }
	
	/*Setters e Getters*/
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
	
	public LocalDate getDataDevolucaoPrevista() {
	    return dataDevolucaoPrevista;
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
