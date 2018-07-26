package src;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

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

    public void reservar(int codigoUsuario, int codigoLivro) {
        Livro l = this.obterLivro(codigoLivro);
        Usuario u = this.obterUsuario(codigoUsuario);

        try {
            LocalDate now = LocalDate.now();
            u.fazerReserva(l, now);

        }catch (OutOfMemoryError e){
            System.out.println("Limite de reservas excedido.");
        }
    }

    public void devolver() {}

    public void observar() {}

    public void emprestar(int codigoUsuario, int codigoLivro) {

        Livro l = this.obterLivro(codigoLivro);
        Usuario u = this.obterUsuario(codigoUsuario);

    }

    public void infoLivro() {}

    public void notificacao(){}

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
