package br.iesb.store.virtualstore.model.builder;

import br.iesb.store.virtualstore.model.EnderecoEntity;

public final class EnderecoEntityBuilder {
    private EnderecoEntity enderecoEntity;

    private EnderecoEntityBuilder() {
        enderecoEntity = new EnderecoEntity();
    }

    public static EnderecoEntityBuilder builder() {
        return new EnderecoEntityBuilder();
    }

    public EnderecoEntityBuilder withCep(String cep) {
        enderecoEntity.setCep(cep);
        return this;
    }

    public EnderecoEntityBuilder withNumero(Integer numero) {
        enderecoEntity.setNumero(numero);
        return this;
    }

    public EnderecoEntityBuilder withEndereco(String endereco) {
        enderecoEntity.setEndereco(endereco);
        return this;
    }

    public EnderecoEntityBuilder withComplemento(String complemento) {
        enderecoEntity.setComplemento(complemento);
        return this;
    }

    public EnderecoEntity build() {
        return enderecoEntity;
    }
}
