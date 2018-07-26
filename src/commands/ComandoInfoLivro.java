package src.commands;

import src.Biblioteca;

public class ComandoInfoLivro implements Command {
    public  boolean execute(String parametro){
        // TODO fazer o método execute

        int codigoLivro = Integer.parseInt(parametro);
        return Biblioteca.getInstancia().infoLivro(codigoLivro);

    }
}
