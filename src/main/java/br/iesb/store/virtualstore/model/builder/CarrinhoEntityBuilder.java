package br.iesb.store.virtualstore.model.builder;

import br.iesb.store.virtualstore.model.CarrinhoEntity;
import br.iesb.store.virtualstore.model.CarrinhoItemEntity;
import br.iesb.store.virtualstore.model.ClienteEntity;

import java.util.List;

public final class CarrinhoEntityBuilder {
    private final CarrinhoEntity carrinhoEntity;

    private CarrinhoEntityBuilder() {
        carrinhoEntity = new CarrinhoEntity();
    }

    public static CarrinhoEntityBuilder builder() {
        return new CarrinhoEntityBuilder();
    }

    public CarrinhoEntityBuilder withCliente(ClienteEntity cliente) {
        carrinhoEntity.setCliente(cliente);
        return this;
    }

    public CarrinhoEntityBuilder withItens(List<CarrinhoItemEntity> itens) {
        carrinhoEntity.setItens(itens);
        return this;
    }

    public CarrinhoEntity build() {
        return carrinhoEntity;
    }
}
