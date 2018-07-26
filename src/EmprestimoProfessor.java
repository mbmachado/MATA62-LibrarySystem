package src;

import java.time.LocalDate;
public class EmprestimoProfessor implements ComportamentoEmprestar {

	@Override
	public void fazerEmprestimo(Livro livro, Usuario usuario) {
		Exemplar exemplar;
		int indiceExemplarDisponivel = livro.getIndiceExemplarDisponivel();
		
		if(usuario.numeroEmprestimosEmAtraso() > 0) {
			System.out.println("N�o foi poss�vel efetuar emprestimo. Usu�rio est� em d�bito!");
		} else {
			if(indiceExemplarDisponivel != -1) { // H� exemplar dispon�vel?
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
				System.out.println("N�o foi poss�vel efetuar emprestimo. N�o h� exemplares dispon�veis");
			}
		
		}

	}

}
