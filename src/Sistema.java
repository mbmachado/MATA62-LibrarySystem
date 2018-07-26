package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import src.commands.*;

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


    public static void  getCommand(String entrada) {

        String[] s = entrada.split(" ", 1);
        String command = s[0];
        String parametros = s[1];

        comandos.get(command).execute(parametros);
    }


	public static void main(String[] args) {
        Sistema sis = new Sistema();
        Scanner sc = new Scanner(System.in);
        String c = sc.next();

        getCommand(c);

	}

}
