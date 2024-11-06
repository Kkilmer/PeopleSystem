package kevin.house.atv1.pessoas;

import kevin.house.atv1.composicao.Cargo;
import kevin.house.atv1.composicao.Endereco;
import kevin.house.atv1.composicao.Telefone;

import java.time.Period;
import java.util.Scanner;
import java.time.LocalDate;

public class Funcionario {
    private Integer matricula;
    private String nome;
    private LocalDate dataNascimento;
    private LocalDate dataAdmissao;
    private Endereco endereco;
    private Telefone telsContato;
    private Cargo cargo;
    private Double salario;
    private String tipoCargoOutros = null;

    private Scanner leitor = new Scanner(System.in);

    public void cadastrar() {
        System.out.println("Informe o nome: ");
        this.nome = leitor.nextLine();

        System.out.println("Informe a data de nascimento! ");
        System.out.println("Informe o dia: ");
        int dia = leitor.nextInt();
        System.out.println("Informe o mês: ");
        int mes = leitor.nextInt();
        System.out.println("Informe o ano: ");
        int ano = leitor.nextInt();
        this.dataNascimento = LocalDate.of(ano, mes, dia);
        leitor.nextLine();

        this.endereco = new Endereco();
        this.endereco.cadastrar();

        this.telsContato = new Telefone();
        this.telsContato.cadastrar();

        System.out.println("Informe a matrícula do cliente: ");
        this.matricula = leitor.nextInt();
        leitor.nextLine();

        System.out.println("Informe o cargo do cliente: ");
        try {
            Cargo cargo = Cargo.valueOf(leitor.nextLine().toUpperCase());
            if (cargo == Cargo.OUTROS) {
                System.out.println("Informe seu cargo: ");
                this.tipoCargoOutros = leitor.nextLine();
            }
            this.cargo = cargo;
        } catch (IllegalArgumentException e) {
            System.out.println("Cargo informado inválido. Por favor, tente novamente.");

        }

        System.out.println("Informe seu salário real: ");
        this.salario = leitor.nextDouble();
        leitor.nextLine();

        System.out.println("Informe a data de admissão: ");
        System.out.println("Informe o dia: ");
        int diaAdmissao = leitor.nextInt();
        System.out.println("Informe o mês: ");
        int mesAdmissao = leitor.nextInt();
        System.out.println("Informe o ano: ");
        int anoAdmissao = leitor.nextInt();
        this.dataAdmissao = LocalDate.of(anoAdmissao, mesAdmissao, diaAdmissao);
    }

    public int obterIdade() {
        LocalDate dataNascimento = this.dataNascimento;
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        return periodo.getYears();
    }

    public void reajustarSalario(double percentual) {
        if (percentual < 0) {
            System.out.println("Percentual de reajuste não pode ser negativo.");
        } else {
            this.salario += this.salario * (percentual / 100);
            System.out.println("Salário reajustado com sucesso.");
        }
    }
    public void promover(Cargo novoCargo) {
        this.cargo = novoCargo;
        if (novoCargo == Cargo.OUTROS) {
            System.out.println("Informe o novo cargo: ");
            this.tipoCargoOutros = leitor.nextLine();
        }
        System.out.println("Funcionário promovido com sucesso.");
    }

    public int obterTempoDeEmpresa() {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(this.dataAdmissao, dataAtual);
        return periodo.getYears();
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Telefone getTelsContato() {
        return telsContato;
    }

    public void setTelsContato(Telefone telsContato) {
        this.telsContato = telsContato;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getTipoCargoOutros() {
        return tipoCargoOutros;
    }

    public void setTipoCargoOutros(String tipoCargoOutros) {
        this.tipoCargoOutros = tipoCargoOutros;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", dataAdmissao=" + dataAdmissao +
                ", endereco=" + endereco +
                ", telsContato=" + telsContato +
                ", cargo=" + cargo +
                ", salario=" + salario +
                ", tipoCargoOutros='" + tipoCargoOutros + '\'' +
                '}';
    }
}
