package main;
import java.time.LocalDate;

public class EmprestimoProfessor implements ComportamentoEmprestar {

	@Override
	public void fazerEmprestimo(Livro livro, Usuario usuario) {
		Exemplar exemplar;
		int indiceExemplarDisponivel = livro.getIndiceExemplarDisponivel();
		
		if(usuario.numeroEmprestimosEmAtraso() > 0) {
			System.out.println("Nãoo foi possível efetuar emprestimo. Usuário está em débito!");
		} else {
			if(indiceExemplarDisponivel != -1) { // Hï¿½ exemplar disponï¿½vel?
				exemplar = livro.obterExemplarParaEmprestimo(indiceExemplarDisponivel);
				if(usuario.jaPossuiEmprestimo(exemplar)) {
					exemplar.setStatus("disponivel");
					System.out.println("Nãoo foi possível efetuar emprestimo. Um Exemplar do livro já se encontra em emprestimo!");
				} else {
					Emprestimo emprestimo = new Emprestimo(exemplar, usuario, LocalDate.now(), LocalDate.now().plusDays(usuario.getTempoDeEmprestimo()), null);
					exemplar.adicionarEmprestimo(emprestimo);
					usuario.adicionarEmprestimo(emprestimo);
					System.out.println("Exemplar de livro emprestado com sucesso!");
				}
			} else {
				System.out.println("Nãoo foi possível efetuar emprestimo. Naõo há exemplares disponíveis");
			}
		
		}

	}

}
