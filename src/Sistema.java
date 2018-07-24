package src;
import java.util.HashMap;
import java.util.Map;

public class Sistema {

    public static HashMap<String, Command> comandos = new HashMap<String, Command>();


    public Sistema() {
//        TODO inicializar os comandos
    }



    public static Command  getCommand(String command) {
        return comandos.get(command);
    }


	public static void main(String[] args) {

	}

}
