package src.commands;

import src.Biblioteca;

public class ComandoSair implements Command {
    public  void execute(String parametros){
         Biblioteca.getInstancia().sair();
    }
}
