package commands;
import main.*;

public class ComandoInfoLivro implements Command {
    public  void execute(String parametro){

        int codigoLivro = Integer.parseInt(parametro);
        Biblioteca.getInstancia().infoLivro(codigoLivro);

    }
}
