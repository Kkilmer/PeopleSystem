package tech.kevin.composicao;

public class Cargo {
    private double salario;
    private String dataAdmissao;
    private String nomeCargo;

    public void Cargo(String nomeCargo, double salario, String dataAdmissao) {
        this.nomeCargo = nomeCargo;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
    }

    public double reajustarSalario(double percentual) {
        double salarioAtual = this.getSalario();
        double novoSalario = salarioAtual * (1 + percentual / 100);
        this.setSalario(novoSalario);
        System.out.println("Valor do salário após reajuste: " + novoSalario);
        return novoSalario;
    }
    public void promover(String novoNomeCargo, double novoSalario) {
        this.setNomeCargo(novoNomeCargo);
        System.out.println("Funcionário promovido para o cargo de " + novoNomeCargo);
    }
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }
}
