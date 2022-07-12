package br.com.java.service;

import java.util.*;
import java.util.regex.Pattern;
import br.com.java.modelo.*;

public interface VagaService {
    
    public static Vaga[] criarEstacionamento() {
        Vaga[] vagas = new Vaga[50];

        for(int index = 1; index <= 50; index++) {
            Vaga vaga = new Vaga(index);
            vagas[index - 1] = vaga;
        }
        return vagas;
    }
    public static void cadastrarVeiculo(Scanner teclado, Veiculo veiculo) {
        System.out.println("Digite o modelo do veículo: ");
        String modelo = teclado.next();

        System.out.println("Digite a placa do veículo: ");
        String placa = teclado.next();

        System.out.println("Digite o nome do proprietário: ");
        String proprietario = teclado.next();

        System.out.println("Digite o documento do proprietário: ");
        String documento = teclado.next();

        veiculo.setModelo(modelo);
        veiculo.setPlaca(placa);
        veiculo.setProprietario(proprietario);
        veiculo.setDocumento(documento);
    }
    public static String validaHora(Scanner teclado) {
        Pattern regex = Pattern.compile("^([0-1]{1})([0-9]{1})\\:([0-5]{1})([0-9]{1})$");
        Pattern regex2 = Pattern.compile("^([2]{1})([0-3]{1})\\:([0-5]{1})([0-9]{1})$");

        do {
            System.out.println("Digite o Horário: ");
            String hora = teclado.next();

            if (regex.matcher(hora).matches() || regex2.matcher(hora).matches()) {
                
                return hora;
            } else {
                System.out.println("\n Erro! Digite um horário dentro do padrão HH:mm e menor que 24 horas! \n");

            }
        } while (true);
    }
    public static String estacionar(Veiculo veiculo, Vaga[] vagas, String hora){

        String texto = "";

        if (buscarVeiculo(veiculo.getPlaca(), vagas) != 51) {
            texto = "\n Este veículo já se encontra estacionado\n";

            return texto;
        }
        for(int index = 0; index <= 49; index++) {
            if (!vagas[index].getOcupado()) {
                vagas[index].setOcupado(true);
                vagas[index].setVeiculo(veiculo);
                vagas[index].setHoraEntrada(hora);

                texto = "\n Estacionado com sucesso ás " + hora + "\n";

                return texto;
            } else if (index == 49) {
                texto = "\n Não há vagas disponíveis \n";

                return texto;
            }
        }
        return texto;
    }
    public static Integer buscarVeiculo(String placa, Vaga[] vagas) {
        Veiculo veiculo;

        Integer posicao = 51;

        for(int index = 0; index <= 49; index++) {
            veiculo = vagas[index].getVeiculo();

            if (vagas[index].getOcupado()) {
                if (veiculo.getPlaca().compareToIgnoreCase(placa) == 0) {
                    posicao = index;
                }
            }
        }
        return posicao;
    }
    public static String retirar(Integer posicao, Vaga[] vagas, String horaSaida, List<Registro> registros) {

        String texto = "";

        vagas[posicao].setHoraSaida(horaSaida);

        texto = "\n" + vagas[posicao].getVeiculo() + ", foi retirado da vaga " + (posicao + 1) + " s" + horaSaida + "\n";

        Double valorHora = RegistroService.calcularValorHora(vagas[posicao]);

        texto += "O valor foi de R$";
        texto += String.format("%.2f\n\n", valorHora);

        RegistroService.atualizarRegistro(registros, vagas[posicao], valorHora);

        vagas[posicao] = new Vaga(posicao);

        return texto;
    }
}
