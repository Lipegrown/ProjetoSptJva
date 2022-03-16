
package classes;

public class Funcionarios {
   public String nome, cpf,rg;
    public double valorHora;
    public int id;

    public Funcionarios(int id, String nome, String cpf, String rg, double valorHora ) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.valorHora = valorHora;
        
    }

    public Funcionarios() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
