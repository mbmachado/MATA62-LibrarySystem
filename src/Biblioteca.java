package src;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import src.Exemplar;

public class Biblioteca {

    private static Biblioteca instancia;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Livro> livros = new ArrayList<Livro>();

    private Biblioteca(){}

    public static Biblioteca getInstancia() {

        if(instancia == null){
            instancia = new Biblioteca();
        }

        return instancia;
    }

    public boolean reservar(int codigoUsuario, int codigoLivro) {
        Livro l = this.obterLivro(codigoLivro);
        Usuario u = this.obterUsuario(codigoUsuario);

        u.fazerReserva(l);

        return true;
    }

    public boolean devolver(int codigoUsuario, int codigoLivro) {

        Usuario u = obterUsuario(codigoUsuario);
        Livro l = obterLivro(codigoLivro);

        // TODO realizar a devolução e exibir mensagem
        //u.fazerDevolucao();

        return true;

    }

    public boolean observar(int codigoUsuario, int codigoLivro) {
        Usuario u = obterUsuario(codigoUsuario);
        Livro l = obterLivro(codigoLivro);

        //TODO chamar o método responsável


        return true;
    }

    public boolean emprestar(int codigoUsuario, int codigoLivro) {

        Livro l = this.obterLivro(codigoLivro);
        Usuario u = this.obterUsuario(codigoUsuario);
//        ArrayList<Exemplar> exemplares = l.getExemplares();
//
//        Exemplar exemplarDisponivel = exemplares.stream()
//                .filter(e -> e.getStatus().equals("Disponível"))
//                .findAny()
//                .orElse(null);

        // TODO exibir mensagem de emprestimo
        u.fazerEmprestimo(l);
        return true;

    }

    public boolean infoLivro(int codigoLivro) {
        Livro l = obterLivro(codigoLivro);
        l.printInfoLivro();
        return true;
    }

    public boolean infoUsuario(int codigoUsuario) {
        Usuario u = obterUsuario(codigoUsuario);
        u.printInfoUsuario();
        return true;
    }

    public boolean notificacao(int codigoUsuario){
        Usuario u = obterUsuario(codigoUsuario);

        //TODO chamar método qtdNoficiacoes do Professor

        return true;
    }

    public boolean sair(){
        return false;
    }

    private  Livro obterLivro(int codigoLivro) {
        Optional<Livro> livro =  livros.stream().filter(l -> l.getCodigo() == codigoLivro).findFirst();
        return livro.orElse(null);
    }

    private Usuario obterUsuario(int codigoUsuario){
        Optional<Usuario> usuario = usuarios.stream().filter(u -> u.getCodigo() == codigoUsuario).findFirst();
        return usuario.orElse(null);
    }
}
