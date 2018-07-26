package commands;
import main.*;

public class ComandoObservar implements Command {
    public  void execute(String parametros){

        String[] exploded = parametros.split(" ");
        int codigoUsuario = Integer.parseInt(exploded[0]);
        int codigoLivro = Integer.parseInt(exploded[1]);

        Biblioteca.getInstancia().observar(codigoUsuario, codigoLivro);

    }
}
