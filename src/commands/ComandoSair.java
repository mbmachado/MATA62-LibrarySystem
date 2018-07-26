package commands;
import main.*;

public class ComandoSair implements Command {
    public  boolean execute(String parametros){
        return Biblioteca.getInstancia().sair();
    }
}
