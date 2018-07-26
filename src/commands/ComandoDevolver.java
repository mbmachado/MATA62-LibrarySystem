package commands;
import main.*;

public class ComandoDevolver implements Command {
    public  void execute(String parametro){
        String[] exploded = parametro.split("\\s+", 2);
        int codigoUsuario = Integer.parseInt(exploded[0]);
        int codigoLivro = Integer.parseInt(exploded[1]);

        Biblioteca.getInstancia().devolver(codigoUsuario, codigoLivro);

    }
}
