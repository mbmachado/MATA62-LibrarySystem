package commands;
import main.*;

public class ComandoInfoLivro implements Command {
    public  void execute(String parametro) throws NumberFormatException {
    	try {
	        int codigoLivro = Integer.parseInt(parametro);
	        Biblioteca.getInstancia().infoLivro(codigoLivro);
    	} catch (NumberFormatException e) {
        	System.out.println("Comando Inválido");
        }
    }
}
