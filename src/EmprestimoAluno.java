package src;
import java.util.ArrayList;
import java.time.LocalDate;

public class EmprestimoAluno implements ComportamentoEmprestar {

	@Override
	public void fazerEmprestimo(Livro livro, Usuario usuario) {
		Exemplar exemplar;
		ArrayList<Reserva> reservas = livro.getReservas();
		int indiceExemplarDisponivel = livro.getIndiceExemplarDisponivel(), indiceReserva = livro.temReserva(usuario);


		if(usuario.numeroEmprestimosEmAtraso() > 0) {
			System.out.println("N�o foi poss�vel efetuar emprestimo. Usu�rio est� em d�bito!");
		} else if(usuario.numeroEmprestimosAtivos() == usuario.getLimiteEmprestimos()) {
			System.out.println("N�o foi poss�vel efetuar emprestimo. Usu�rio estourou limite de emprestimos!");
		} else {
			if(indiceExemplarDisponivel != -1) { // H� exemplar dispon�vel?
				if(indiceReserva != -1) { // Tem reserva?
					livro.removerReserva(indiceReserva);
					exemplar = livro.obterExemplarParaEmprestimo(indiceExemplarDisponivel);
					if(usuario.jaPossuiEmprestimo(exemplar)) {
						exemplar.setStatus("disponivel");
						System.out.println("N�o foi poss�vel efetuar emprestimo. Um Exemplar do livro j� se encontra em emprestimo!");
					} else {
						Emprestimo emprestimo = new Emprestimo(exemplar, usuario, LocalDate.now(), LocalDate.now().plusDays(usuario.getTempoDeEmprestimo()), null);
						exemplar.adicionarEmprestimo(emprestimo);
						usuario.adicionarEmprestimo(emprestimo);
						System.out.println("Exemplar de livro emprestado com sucesso!");
					}

				} else if(reservas.size() < livro.numeroDeExemplaresDisponiveis()) { //H� livros sem reserva?
					exemplar = livro.obterExemplarParaEmprestimo(indiceExemplarDisponivel);
					if(usuario.jaPossuiEmprestimo(exemplar)) {
						exemplar.setStatus("disponivel");
						System.out.println("N�o foi poss�vel efetuar emprestimo. Um Exemplar do livro j� se encontra em emprestimo!");
					} else {
						Emprestimo emprestimo = new Emprestimo(exemplar, usuario, LocalDate.now(), LocalDate.now().plusDays(usuario.getTempoDeEmprestimo()), null);
						exemplar.adicionarEmprestimo(emprestimo);
						usuario.adicionarEmprestimo(emprestimo);
						System.out.println("Exemplar de livro emprestado com sucesso!");
					}
				} else {
					System.out.println("N�o foi poss�vel efetuar emprestimo. Todos os exemplares t�m reserva!");
				}
			} else {
				System.out.println("N�o foi poss�vel efetuar emprestimo. N�o h� exemplares dispon�veis");
			}

		}

	}

}
