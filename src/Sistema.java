
import java.util.HashMap;
import java.util.Scanner;

public class Sistema {

    public static HashMap<String, Command> comandos = new HashMap<String, Command>();


    public Sistema() {
        comandos.put("emp", new ComandoEmprestar());
        comandos.put("dev", new ComandoDevolver());
        comandos.put("res", new ComandoReservar());
        comandos.put("obs", new ComandoObservar());
        comandos.put("liv", new ComandoInfoLivro());
        comandos.put("usu", new ComandoInfoUsuario());
        comandos.put("ntf", new ComandoNotificacao());
        comandos.put("sai", new ComandoSair());
    }


    public static void  getCommand(String command) {
         comandos.get(command).execute();
    }


	public static void main(String[] args) {
        Sistema sis = new Sistema();
        Scanner sc = new Scanner(System.in);
        String c = sc.next();

        getCommand(c);

	}

}
