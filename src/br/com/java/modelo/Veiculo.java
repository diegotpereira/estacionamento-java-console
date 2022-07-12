package br.com.java.modelo;

public class Veiculo {
 
    private String modelo;
    private String placa;
    private String proprietario;
    private String documento;
    
    public Veiculo() {
    }

    public Veiculo(String modelo, String placa, String proprietario, String documento) {
        this.modelo = modelo;
        this.placa = placa;
        this.proprietario = proprietario;
        this.documento = documento;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getProprietario() {
        return proprietario;
    }
    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
