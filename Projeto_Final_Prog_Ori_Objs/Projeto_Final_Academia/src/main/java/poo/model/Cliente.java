package poo.model;

import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa {
    private String plano;

    public Cliente() {
    }

    public Cliente(String cpf, String nome, String plano) {
        super(cpf, nome);
        this.plano = plano;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + getCpf() + '\'' +
                ", nome='" + getNome() + '\'' +
                ", plano='" + plano + '\'' +
                '}';
    }
}
