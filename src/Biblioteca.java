import java.util.ArrayList;

public class Biblioteca {
    private static Biblioteca instancia;
    private ArrayList usuarios = new ArrayList<Usuario>();
    // TODO fazer o array list de livros;

    private Biblioteca(){}

    public static Biblioteca getInstancia() {

        if(instancia == null){
            instancia = new Biblioteca();
        }

        return instancia;
    }

    public void reservar() {}

    public void devolver() {}

    public void observar() {}

    public void emprestar() {}

    public void infoLivro() {}

    public void notificacao(){}

    public void sair(){}

    // TODO criar a classe Livro para implementar esse método
    //public Livro obterLivro() {}


    public Usuario obterUsuario(String nome){return null;}
}
