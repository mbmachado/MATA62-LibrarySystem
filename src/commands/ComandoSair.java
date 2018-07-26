package commands;

import src.Biblioteca;

public class ComandoSair implements Command {
    public  boolean execute(String parametros){
        return Biblioteca.getInstancia().sair();
    }
}
