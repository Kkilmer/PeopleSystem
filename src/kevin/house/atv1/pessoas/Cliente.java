package kevin.house.atv1.pessoas;

import kevin.house.atv1.composicao.Profissao;

import java.util.Scanner;

public class Cliente extends Funcionario {
    private String codigo;
    private String nome;
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

    public void cadastrar(){
        super.cadastrar();
        System.out.println("Informe o código do cliente: ");
        this.codigo = leitor.nextLine();
        System.out.println("Informe a profissão do cliente: ");
        Profissao profissao1 = Profissao.valueOf(leitor.nextLine());
        if(profissao1 == Profissao.OUTROS){
            System.out.println(("Informe sua profissão: "));
            this.tipoProfissaoOutros = leitor.nextLine();
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo='" + codigo + '\'' +
                ", profissao=" + profissao +
                ", tipoProfissaoOutros='" + tipoProfissaoOutros + '\'' +
                '}';
    }
}
