package commands;

import src.Biblioteca;

public class ComandoDevolver implements Command {
    public  boolean execute(String parametro){
        // TODO fazer o método execute
        String[] exploded = parametro.split(" ");
        int codigoUsuario = Integer.parseInt(exploded[0]);
        int codigoLivro = Integer.parseInt(exploded[1]);

       return Biblioteca.getInstancia().devolver(codigoUsuario, codigoLivro);

    }
}
