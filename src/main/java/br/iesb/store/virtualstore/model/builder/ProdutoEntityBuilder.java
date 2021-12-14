package br.iesb.store.virtualstore.model.builder;

import br.iesb.store.virtualstore.model.ProdutoEntity;

import java.math.BigDecimal;

public final class ProdutoEntityBuilder {
    private final ProdutoEntity produtoEntity;

    private ProdutoEntityBuilder() {
        produtoEntity = new ProdutoEntity();
    }

    public static ProdutoEntityBuilder builder() {
        return new ProdutoEntityBuilder();
    }

    public ProdutoEntityBuilder withCode(String code) {
        produtoEntity.setCode(code);
        return this;
    }

    public ProdutoEntityBuilder withNome(String nome) {
        produtoEntity.setNome(nome);
        return this;
    }

    public ProdutoEntityBuilder withDescricao(String descricao) {
        produtoEntity.setDescricao(descricao);
        return this;
    }

    public ProdutoEntityBuilder withPreco(BigDecimal preco) {
        produtoEntity.setPreco(preco);
        return this;
    }

    public ProdutoEntity build() {
        return produtoEntity;
    }
}
