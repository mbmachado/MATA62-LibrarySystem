package src.commands;
import src.Biblioteca;

public class ComandoEmprestar implements Command {
    public void execute(String parametros){
        String[] exploded = parametros.split(" ");

        int codigoUsuario = Integer.parseInt(exploded[0]);
        int codigoLivro = Integer.parseInt(exploded[1]);

        Biblioteca.getInstancia().emprestar(codigoUsuario, codigoLivro);
    }
}
