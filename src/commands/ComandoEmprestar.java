package commands;
import main.*;

public class ComandoEmprestar implements Command {
    public boolean execute(String parametros){
        String[] exploded = parametros.split(" ");

        int codigoUsuario = Integer.parseInt(exploded[0]);
        int codigoLivro = Integer.parseInt(exploded[1]);

        return Biblioteca.getInstancia().emprestar(codigoUsuario, codigoLivro);
    }
}
