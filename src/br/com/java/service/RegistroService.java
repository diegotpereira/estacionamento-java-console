package br.com.java.service;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import br.com.java.modelo.*;

public interface RegistroService {
    
    public static String retornarRegistros(List<Registro> registros) {
        String texto = "";

        for(Registro registro : registros) {
            texto += registro;
        }
        if (registros.isEmpty()) {
            texto = "A lista de registros está vazia \n";
        }
        return texto;
    }
    public static Double calcularValorHora(Vaga vaga) {
        LocalTime inicio = LocalTime.parse(vaga.getHoraEntrada());
        LocalTime termino = LocalTime.parse(vaga.getHoraSaida());

        Double taxa = 10.0;

        int tempoMinutos = (int) ChronoUnit.MINUTES.between(inicio, termino);

        int horas = tempoMinutos / 60;
        int minutos = tempoMinutos % 60;

        Double resultado = (horas + (minutos * 0.017)) * taxa;

        return resultado;

    }
    public static void atualizarRegistro(List<Registro> registros, Vaga vaga, Double valorHora) {
        Registro registro = new Registro();
        registro.setVeiculo(vaga.getVeiculo());
        registro.setHoraDeEntrada(vaga.getHoraEntrada());
        registro.setHoraDeSaida(vaga.getHoraSaida());
        registro.setValor(valorHora);
        registro.setRegistro(registros.size() + 1);
        registro.setVaga(vaga.getPosicao());
        registros.add(registro);
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
}
