import java.time.LocalDate;

public class EmprestimoProfessor implements ComportamentoEmprestar {

	@Override
	public void fazerEmprestimo(Livro livro, Usuario usuario) {
		Exemplar exemplar;
		int indiceExemplarDisponivel = livro.getIndiceExemplarDisponivel();
		
		if(usuario.numeroEmprestimosEmAtraso() > 0) {
			System.out.println("Não foi possível efetuar emprestimo. Usuário está em débito!");
		} else {
			if(indiceExemplarDisponivel != -1) { // Há exemplar disponível?
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
				System.out.println("Não foi possível efetuar emprestimo. Não há exemplares disponíveis");
			}
		
		}

	}

}
