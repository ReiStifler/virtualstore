package br.iesb.store.virtualstore.request;

import java.math.BigDecimal;

public class ProdutoRequest {

    private String code;
    private String nome;
    private String descricao;
    private BigDecimal preco;

    public String getCode() {
        return code;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
