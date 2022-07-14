package br.com.java.service;

import java.util.*;
import br.com.java.modelo.*;

public interface Menu {
    
    public static void apresentarMenu(Vaga[] vagas, Scanner teclado, List<Registro> registros) {
        
        while (true) {
            System.out.println("1 - Estacionar" + 
                             "\n2 - Retirar" + 
                             "\n3 - Mostrar Vagas Livres" + 
                             "\n4 - Mostrar Vagas Ocupadas" + 
                             "\n5 - Buscar Veículo" + 
                             "\n6 - Mostrar Registro" + 
                             "\n7 - Mostrar Valor do dia" + 
                             "\n8 - Sair" + "\n");

            System.out.println("Digite a opção desejada");

            int opcao = 0;

            try {
                opcao = teclado.nextInt();

                System.out.println();

                if (opcao == 8) {
                    System.out.println("Obrigado por usar o sistema de gerenciamento de veículos! Até breve");

                    teclado.close();
                    break;
                } else {
                    escolherOpcaoDoMenu(opcao, vagas, teclado, registros);
                }
            } catch (InputMismatchException e) {
                //TODO: handle exception
                System.err.println("\n Digite apenas números inteiros! \n");
                teclado.next();
            }
            System.out.println("============================================");
        }
    }
    public static void escolherOpcaoDoMenu(int valorMenu, Vaga[] vagas, Scanner teclado, List<Registro> registros) {

        switch (valorMenu) {
            case 1:
                estacionar(vagas, teclado);
            break;

            case 2:
                retirarVeiculo(vagas, teclado, registros);
            break;

            case 5:
                buscarVeiculo(vagas, teclado);
        
            case 6:
            System.out.println(RegistroService.retornarRegistros(registros));
            
            default:
                break;
        }
    }
    public static void estacionar(Vaga[] vagas, Scanner teclado) {
        Veiculo veiculo = new Veiculo();

        VagaService.cadastrarVeiculo(teclado, veiculo);

        String hora =  VagaService.validaHora(teclado);

        System.out.println(VagaService.estacionar(veiculo, vagas, hora));
    }
    public static void retirarVeiculo(Vaga[] vagas, Scanner teclado, List<Registro> registros) {
        boolean horaValida = false;

        System.out.println("Digite a placa do veículo: ");
        String placa = teclado.next();

        Integer posicao = VagaService.buscarVeiculo(placa, vagas);

        if (posicao == 51) {
            System.out.println("\n Carro não encontrado \n");

            return;
        } else {

            do {
                String hora = VagaService.validaHora(teclado);

                String hr[] = hora.split(":");

                Integer hrs = Integer.parseInt(hr[0]);
                Integer mins = Integer.parseInt(hr[1]);

                String horaEntrada = vagas[posicao].getHoraEntrada();
                String hrEnt[] = horaEntrada.split(":");

                Integer hrsEnt = Integer.parseInt(hrEnt[0]);
                Integer minEnt = Integer.parseInt(hrEnt[1]);

                if (hrs < hrsEnt) {
                    System.out.println("\n Digite um horário maior que o horário de entrada! \n");
                } else {
                    if (hrs == hrsEnt && mins < minEnt) {
                        System.out.println("\n Digite um horário maior que o horário de entrada! \n");
                    } else {
                        horaValida = true;

                        System.out.println(VagaService.retirar(posicao, vagas, hora, registros));
                    }
                }
            } while(!horaValida);
        }

    }
    public static void buscarVeiculo (Vaga[] vagas, Scanner teclado) {
        System.out.println("Digite a placa");
        String placa = teclado.next();

        Integer posicao = RegistroService.buscarVeiculo(placa, vagas);

        if (posicao != 51) {
            System.out.println("\n Carro de placa: " + placa + ", está na vaga: " + (posicao + 1) + "\n");
        } else {
            System.out.println("\n ESte carro não foi encontrado. |n");
        }
    }
}
