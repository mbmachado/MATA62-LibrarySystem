package src;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
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

        String[] s = entrada.split(";", 1);
        System.out.println(Arrays.toString(s));
//        String command = s[0];
//        String parametros = s[1];
//
//        comandos.get(command).execute(parametros);
    }


	public static void main(String[] args) {
        Sistema sis = new Sistema();
        Scanner sc = new Scanner(System.in);
        Usuario u1 = new Graduacao("Otávio", 123);
        Livro l1 = new Livro("Engenharia de Softwore", "Fulano", 14,"26/07/2018", "UFBA", "1 ed.");

        String s = sc.nextLine();
        System.out.println(s);

	}

}
