package main;
import java.util.HashMap;
import java.util.Scanner;
import commands.*;

public class Sistema {

    private HashMap<String, Command> comandos = new HashMap<String, Command>();

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

    public void getCommand(String entrada) throws IndexOutOfBoundsException {

    	String[] s = entrada.split("\\s+", 2);
        try {
            String command = s[0];
            String parametros = s[1];
            comandos.get(command).execute(parametros);
        } catch (IndexOutOfBoundsException e) {
            String command = s[0];
            comandos.get(command).execute("");
        }
    }

	public static void main(String[] args) {
        Sistema sistema = new Sistema();
        
		Usuario usr1 = new Graduacao("João da Silva", 123);
		Usuario usr2 = new PosGraduacao("Luiz Fernando Rodrigues", 456);
		Usuario usr3 = new Graduacao("Pedro Paulo", 789);
		Usuario usr4 = new Professor("Carlos Lucena", 100);
		
		Livro liv1 = new Livro("Engenharia de Software", "Ian Sommervile", 100, "2000", "AddisonWernsley", "6°");
		Livro liv2 = new Livro("UML – Guia do Usuário", "Grady Booch, James Rumbaugh, Ivar Jacobson", 101, "2000", "AddisonWernsley", "7°");
		Livro liv3 = new Livro("Code Complete", "Steve McConnell", 200, "2014", "AddisonWernsley", "2°");
		Livro liv4 = new Livro("Agile Software Development, Principles, Patterns, and Practices", "Robert Martin", 201, "2002", "AddisonWernsley", "1°");
		Livro liv5 = new Livro("Refactoring: Improving the Design of Existing Code", "Martin Fowler", 300, "1999", "AddisonWernsley", "1°");
		Livro liv6 = new Livro("Software Metrics: Rigorous and Practical Approach", "Norman Fenton, James Bieman", 301, "2014", "AddisonWernsley", "3°");
		Livro liv7 = new Livro("Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", 400, "1994", "AddisonWernsley", "1°");
		Livro liv8 = new Livro("UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Martin Fowler", 401, "2003", "AddisonWernsley", "3°");
		
		Exemplar exm1 = new Exemplar(1, liv1);
		Exemplar exm2 = new Exemplar(2, liv1);
		Exemplar exm3 = new Exemplar(3, liv2);
		Exemplar exm4 = new Exemplar(4, liv3);
		Exemplar exm5 = new Exemplar(5, liv4);
		Exemplar exm6 = new Exemplar(6, liv5);
		Exemplar exm7 = new Exemplar(7, liv5);
		Exemplar exm8 = new Exemplar(8, liv7);
		Exemplar exm9 = new Exemplar(9, liv7);
		Exemplar exm10 = new Exemplar(10, liv1);
		
		liv1.adicionarExemplar(exm1);
		liv1.adicionarExemplar(exm2);
		liv1.adicionarExemplar(exm10);
		liv2.adicionarExemplar(exm3);
		liv3.adicionarExemplar(exm4);
		liv4.adicionarExemplar(exm5);
		liv5.adicionarExemplar(exm6);
		liv5.adicionarExemplar(exm7);
		liv7.adicionarExemplar(exm8);
		liv7.adicionarExemplar(exm9);	
        
        Scanner sc = new Scanner(System.in);

        while (true) {
            String c = sc.nextLine();
            sistema.getCommand(c);
        } 
	}
}
