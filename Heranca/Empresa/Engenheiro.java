package Heranca.Empresa;

import java.math.BigDecimal;

import javax.xml.validation.Validator;

public class Engenheiro {
    private String nome;
    private Integer cpf;
    private Integer telefone;
    private String crea;
    private String projeto;

    public Engenheiro(){

    }

    public Engenheiro(String nome, Integer cpf, Integer telefone, String crea, String projeto) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.crea = crea;
        this.projeto = projeto;
    }


    public String getNome(){
        return this.nome;
    }

    public void setNome(String n){
        this.nome = n;
    }

    public String getCpf(){
        return this.Cpf;
    }

    public void setCpf(String c){
        this.cpf = c;
    }

    public String getTelefone(){
        return this.Telefone;
    }

    public void setTelefone(String t){
        this.Telefone = t;
    }

    public String getCrea(){
        return this.crea;
    }

    public void setcrea(String cr){
        this.crea = cr;
    }

    public String getProjeto(){
        return this.projeto;
    }

    public void setprojeto(String p){
        this.projeto = p;
    }

    public BigDecimal getsalario(){
        return new BigDecimal(val:10000.00);
    }

    public BigDecimal getBonificacao(){
        return getsalario().multiply(new BigDecimal(val:0.15));
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", cpf='" + getCpf() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", crea='" + getCrea() + "'" +
            ", salario='" + getsalario() + "'" +
            ", Bonificacao='" + getBonificacao() + "'" +
            "}";
    }

}
