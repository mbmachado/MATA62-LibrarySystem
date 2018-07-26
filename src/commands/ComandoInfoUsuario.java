package src.commands;

import src.Biblioteca;

public class ComandoInfoUsuario implements Command {
    public  void execute(String parametro){
        int codigoUsuario = Integer.parseInt(parametro);
        Biblioteca.getInstancia().infoUsuario(codigoUsuario);
    }
}
