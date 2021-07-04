package tads.eaj.ufrn.testeimplantacao.models;

public class Produto {
    private String modelo;
    private String marca;
    private double preco;
    private String anolancamento;
    private String ram;

    public Produto(String modelo, String marca, double preco, String anolancamento, String ram, int estoque) {
        super();
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
        this.anolancamento = anolancamento;
        this.ram = ram;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getAnolancamento() {
        return anolancamento;
    }

    public void setAnolancamento(String anolancamento) {
        this.anolancamento = anolancamento;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

}

