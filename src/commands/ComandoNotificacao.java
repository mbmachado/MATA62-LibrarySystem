package src.commands;

import src.Biblioteca;

public class ComandoNotificacao implements Command {
    public  void execute(String parametros){
        int codigoUsuario = Integer.parseInt(parametros);
        Biblioteca.getInstancia().notificacao(codigoUsuario);
    }
}
