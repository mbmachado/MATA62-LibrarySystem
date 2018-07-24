package src;
import java.util.HashMap;


public class Sistema {

    public HashMap<String, Command> comandos = new HashMap<String, Command>();

    public Command  getCommand(String command) {
        return comandos.get(command);
    }


	public static void main(String[] args) {



	}

}
