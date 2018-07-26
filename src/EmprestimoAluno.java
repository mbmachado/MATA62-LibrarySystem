import java.util.ArrayList;
import java.time.LocalDate;

public class EmprestimoAluno implements ComportamentoEmprestar {

	@Override
	public void fazerEmprestimo(Livro livro, Usuario usuario) {
		Exemplar exemplar;
		ArrayList<Reserva> reservas = livro.getReservas();
		int indiceExemplarDisponivel = livro.getIndiceExemplarDisponivel(), indiceReserva = livro.temReserva(usuario);
		
	
		if(usuario.numeroEmprestimosEmAtraso() > 0) {
			System.out.println("Não foi possível efetuar emprestimo. Usuário está em débito!");
		} else if(usuario.getEmprestimos().size() == usuario.getLimiteEmprestimos()) {
			System.out.println("Não foi possível efetuar emprestimo. Usuário estourou limite de emprestimos!");
		} else {
			if(indiceExemplarDisponivel != -1) { // Há exemplar disponível?
				if(indiceReserva != -1) { // Tem reserva?
					livro.removerReserva(indiceReserva);
					exemplar = livro.obterExemplarParaEmprestimo(indiceExemplarDisponivel);
					if(usuario.jaPossuiEmprestimo(exemplar)) {
						System.out.println("Não foi possível efetuar emprestimo. Um Exemplar do livro já se encontra em emprestimo!");
					} else {
						Emprestimo emprestimo = new Emprestimo(exemplar, usuario, LocalDate.now(), LocalDate.now().plusDays(usuario.getTempoDeEmprestimo()), null);
						exemplar.adicionarEmprestimo(emprestimo);
						usuario.adicionarEmprestimo(emprestimo);
						System.out.println("Exemplar de livro emprestado com sucesso!");
					}
					
				} else if(reservas.size() < livro.numeroDeExemplaresDisponiveis()) { //Há livros sem reserva?
					exemplar = livro.obterExemplarParaEmprestimo(indiceExemplarDisponivel);
					if(usuario.jaPossuiEmprestimo(exemplar)) {
						System.out.println("Não foi possível efetuar emprestimo. Um Exemplar do livro já se encontra em emprestimo!");
					} else {
						Emprestimo emprestimo = new Emprestimo(exemplar, usuario, LocalDate.now(), LocalDate.now().plusDays(usuario.getTempoDeEmprestimo()), null);
						exemplar.adicionarEmprestimo(emprestimo);
						usuario.adicionarEmprestimo(emprestimo);
						System.out.println("Exemplar de livro emprestado com sucesso!");
					}
				} else {
					System.out.println("Não foi possível efetuar emprestimo. Todos os exemplares têm reserva!");
				}
			} else {
				System.out.println("Não foi possível efetuar emprestimo. Não há exemplares disponíveis");
			}
		
		} 
		
	}
	
}
