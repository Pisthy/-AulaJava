package Heranca.Empresa;

import java.math.BigDecimal;

public class gerente {
    private String nome;
    private Integer cpf;
    private Integer telefone;
    private Integer quantidadeGerenciado;
}

    public gerente() {
    }

    public gerente(String nome, Integer cpf, Integer telefone, Integer quantidadeGerenciado) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.quantidadeGerenciado = quantidadeGerenciado;
    }

    public BigDecimal getsalario(){
        return new BigDecimal(val:10000.00);
    }

    public BigDecimal getBonificacao(){
        return getsalario().multiply(new BigDecimal(val:0.35));
    }


    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", cpf='" + getCpf() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", quantidadeGerenciado='" + getQuantidadeGerenciado() + "'" +
            ", salario='" + getsalario() + "'" +
            ", bonificacao='" + getBonificacao().setScale(2) + "'" + 
            "}";
    }
