package Atividade5.Estoque;

public class laranja extends frutasgeral {
    private Float preco;

    public laranja() {
    }

    public laranja(String nome, int codigo, int quantidade, Float preco) {
        super(nome, codigo, quantidade);
        this.preco = preco;
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

    public Float getPreco() {
        return this.preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "{" +
            "Nome='" + getNome() + "'" +
            ", Código='" + getCodigo() + "'" +
            ", Quantidade='" + getQuantidade() + "'" +
            ", Preço='" + getPreco() + "'" +
            "}";
    }

}