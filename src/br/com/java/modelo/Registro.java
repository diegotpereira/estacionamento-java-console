package br.com.java.modelo;

public class Registro {
    
    private int registro;
    private String horaDeEntrada;
    private String horaDeSaida;
    private Double valor;
    private Integer vaga;
    private Veiculo veiculo;
    
    public Registro() {
    }

    public Registro(int registro, String horaDeEntrada, String horaDeSaida, Double valor, Integer vaga,
            Veiculo veiculo) {
        this.registro = registro;
        this.horaDeEntrada = horaDeEntrada;
        this.horaDeSaida = horaDeSaida;
        this.valor = valor;
        this.vaga = vaga;
        this.veiculo = veiculo;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public String getHoraDeEntrada() {
        return horaDeEntrada;
    }

    public void setHoraDeEntrada(String horaDeEntrada) {
        this.horaDeEntrada = horaDeEntrada;
    }

    public String getHoraDeSaida() {
        return horaDeSaida;
    }

    public void setHoraDeSaida(String horaDeSaida) {
        this.horaDeSaida = horaDeSaida;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getVaga() {
        return vaga;
    }

    public void setVaga(Integer vaga) {
        this.vaga = vaga;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
