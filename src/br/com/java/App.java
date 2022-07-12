package br.com.java;

import java.util.*;
import br.com.java.modelo.*;
import br.com.java.service.*;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);

        Vaga[] vagas = VagaService.criarEstacionamento();
        List<Registro> registros = new ArrayList<>();

        System.out.println("Olá Bem Vindo ao Sistema!");

        Menu.apresentarMenu(vagas, teclado, registros);
    }
}
