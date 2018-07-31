package commands;
import main.*;

public class ComandoInfoUsuario implements Command {
    public void execute(String parametro) throws NumberFormatException {
        try {
        	int codigoUsuario = Integer.parseInt(parametro);
            Biblioteca.getInstancia().infoUsuario(codigoUsuario);
        } catch (NumberFormatException e) {
        	System.out.println("Comando Inválido");
        }
    	
    }
}
