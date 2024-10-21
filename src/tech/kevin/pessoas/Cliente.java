package tech.kevin.pessoas;

import tech.kevin.composicao.Profissao;

import java.time.LocalDate;
import java.util.Scanner;

public class Cliente extends Pessoa{
    private String codigo;
    private Profissao profissao;
    private String tipoProfissaoOutros;
    private Scanner leitor = new Scanner(System.in);

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public void cadastrar() {
        super.cadastrar();
        System.out.println("Informe o código do cliente: ");
        this.codigo = leitor.nextLine();
        System.out.println("Informe a profissão do cliente: ");
        Profissao profissao = Profissao.valueOf(leitor.nextLine());
        if(profissao == Profissao.OUTROS){
            System.out.println(("Informe sua profissão: "));
            this.tipoProfissaoOutros = leitor.nextLine();
        }

    }

    public void atualizarInformacoes(){
        System.out.println("Desejo atualizar as informações pessoas?");
        String resposta = leitor.nextLine();
        if(resposta.equalsIgnoreCase("S")){
            System.out.println("Informe o nome atualizado: ");
            this.setNome(leitor.nextLine());

            System.out.println("Deseja atualizar a data de nascimento?");
            resposta = leitor.nextLine();
            if(resposta.equalsIgnoreCase("S")){
                System.out.println("Informe o dia atualizada: ");
                int dia = leitor.nextInt();
                System.out.println("Informe o mês atualizada: ");
                int mes = leitor.nextInt();
                System.out.println("Informe o ano atualizada: ");
                int ano = leitor.nextInt();
                leitor.nextLine();
                this.setDataNascimento(LocalDate.of(ano, mes, dia));
            }
            System.out.println("Deseja atualizar o endereço?");
            resposta = leitor.nextLine();

        }

    }

    public String toString() {
        return "Cliente{" +
                "codigo='" + codigo + '\'' +
                ", profissao=" + profissao +
                ", tipoProfissaoOutros='" + tipoProfissaoOutros + '\'' +
                "} ";
    }
}