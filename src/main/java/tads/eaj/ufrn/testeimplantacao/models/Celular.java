package tads.eaj.ufrn.testeimplantacao.models;

public class Celular {
    private int id;
    private String modelo;
    private String marca;
    private double preco;
    private int anolancamento;
    private int ram;

    public Celular(String modelo, String marca, double preco, int anolancamento, int ram) {
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
        this.anolancamento = anolancamento;
        this.ram = ram;
    }
    public Celular(int id,String modelo, String marca, double preco, int anolancamento, int ram) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
        this.anolancamento = anolancamento;
        this.ram = ram;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAnolancamento() {
        return anolancamento;
    }

    public void setAnolancamento(int anolancamento) {
        this.anolancamento = anolancamento;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}

