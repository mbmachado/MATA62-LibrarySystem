package commands;
import main.*;

public class ComandoNotificacao implements Command {
    public  boolean execute(String parametros){
        int codigoUsuario = Integer.parseInt(parametros);
        return Biblioteca.getInstancia().notificacao(codigoUsuario);
    }
}
