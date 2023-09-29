package Atividade5.Estoque;

public class frutasgeral {
    
    protected String nome;
    protected Integer codigo;
    protected Integer quantidade;
    


    public frutasgeral() {
    }

    public frutasgeral(String nome, int codigo, int quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
    }
    

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", codigo='" + getCodigo() + "'" +
            ", quantidade='" + getQuantidade() + "'" +
            "}";
    }


}