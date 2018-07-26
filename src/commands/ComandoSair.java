package commands;
import main.*;

public class ComandoSair implements Command {
    public  void execute(String parametros){
         Biblioteca.getInstancia().sair();
    }
}
