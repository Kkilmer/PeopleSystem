package kevin.house.atv1.main;

import kevin.house.atv1.pessoas.Funcionario;
import kevin.house.atv1.composicao.Cargo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Funcionario funcionario = null;
        boolean running = true;

        while (running) {
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Reajustar Salário");
            System.out.println("3. Promover Funcionário");
            System.out.println("4. Obter Tempo de Empresa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    funcionario = cadastrarFuncionario();
                    break;
                case "2":
                    if (funcionario != null) {
                        reajustarSalario(funcionario);
                    } else {
                        System.out.println("Nenhum funcionário cadastrado.");
                    }
                    break;
                case "3":
                    if (funcionario != null) {
                        promoverFuncionario(funcionario);
                    } else {
                        System.out.println("Nenhum funcionário cadastrado.");
                    }
                    break;
                case "4":
                    if (funcionario != null) {
                        obterTempoDeEmpresa(funcionario);
                    } else {
                        System.out.println("Nenhum funcionário cadastrado.");
                    }
                    break;
                case "5":
                    System.out.println("Saindo...");
                    running = false;
                    saiuMesmo();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    public static Funcionario cadastrarFuncionario() {
        System.out.println("Cadastro de Funcionário:");
        Funcionario funcionario = new Funcionario();
        funcionario.cadastrar();
        System.out.println(funcionario);
        return funcionario;
    }

    public static void reajustarSalario(Funcionario funcionario) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o percentual de reajuste salarial: ");
        double percentual = scanner.nextDouble();
        funcionario.reajustarSalario(percentual);
        System.out.println("Novo salário: " + funcionario.getSalario());
    }

    public static void promoverFuncionario(Funcionario funcionario) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o novo cargo: ");
        try {
            Cargo novoCargo = Cargo.valueOf(scanner.nextLine().toUpperCase());
            funcionario.promover(novoCargo);
            System.out.println("Novo cargo: " + funcionario.getCargo());
        } catch (IllegalArgumentException e) {
            System.out.println("Cargo informado inválido.");
        }
    }

    public static void obterTempoDeEmpresa(Funcionario funcionario) {
        int tempoDeEmpresa = funcionario.obterTempoDeEmpresa();
        System.out.println("Tempo de empresa: " + tempoDeEmpresa + " anos.");
    }

    public static void saiuMesmo() {
        System.out.println("Saiu mesmo mesmo!");
    }
}
