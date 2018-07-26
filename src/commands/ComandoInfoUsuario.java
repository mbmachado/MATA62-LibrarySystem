package commands;

import src.Biblioteca;

public class ComandoInfoUsuario implements Command {
    public  boolean execute(String parametro){
        int codigoUsuario = Integer.parseInt(parametro);
        return Biblioteca.getInstancia().infoUsuario(codigoUsuario);
    }
}
