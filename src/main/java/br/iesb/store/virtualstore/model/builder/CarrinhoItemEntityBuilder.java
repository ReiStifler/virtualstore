package br.iesb.store.virtualstore.model.builder;

import br.iesb.store.virtualstore.model.CarrinhoEntity;
import br.iesb.store.virtualstore.model.CarrinhoItemEntity;
import br.iesb.store.virtualstore.model.ProdutoEntity;

import java.math.BigDecimal;

public final class CarrinhoItemEntityBuilder {
    private final CarrinhoItemEntity carrinhoItemEntity;

    private CarrinhoItemEntityBuilder() {
        carrinhoItemEntity = new CarrinhoItemEntity();
    }

    public static CarrinhoItemEntityBuilder builder() {
        return new CarrinhoItemEntityBuilder();
    }

    public CarrinhoItemEntityBuilder withCarrinho(CarrinhoEntity carrinho) {
        carrinhoItemEntity.setCarrinho(carrinho);
        return this;
    }

    public CarrinhoItemEntityBuilder withProduto(ProdutoEntity produto) {
        carrinhoItemEntity.setProduto(produto);
        return this;
    }

    public CarrinhoItemEntityBuilder withQuantidade(Integer quantidade) {
        carrinhoItemEntity.setQuantidade(quantidade);
        return this;
    }

    public CarrinhoItemEntityBuilder withPreco(BigDecimal preco) {
        carrinhoItemEntity.setPreco(preco);
        return this;
    }

    public CarrinhoItemEntity build() {
        return carrinhoItemEntity;
    }
}
