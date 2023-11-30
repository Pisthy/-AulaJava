package poo.model;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa {
    private String funcao;

    public Funcionario() {
    }

    public Funcionario(String cpf, String nome, String funcao) {
        super(cpf, nome);
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "cpf='" + getCpf() + '\'' +
                ", nome='" + getNome() + '\'' +
                ", funcao='" + funcao + '\'' +
                '}';
    }
}
