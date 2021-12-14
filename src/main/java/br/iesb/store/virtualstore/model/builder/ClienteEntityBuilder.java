package br.iesb.store.virtualstore.model.builder;

import br.iesb.store.virtualstore.model.ClienteEntity;
import br.iesb.store.virtualstore.model.EnderecoEntity;

import java.util.Date;

public final class ClienteEntityBuilder {
    private final ClienteEntity clienteEntity;

    private ClienteEntityBuilder() {
        clienteEntity = new ClienteEntity();
    }

    public static ClienteEntityBuilder builder() {
        return new ClienteEntityBuilder();
    }

    public ClienteEntityBuilder withNome(String nome) {
        clienteEntity.setNome(nome);
        return this;
    }

    public ClienteEntityBuilder withEmail(String email) {
        clienteEntity.setEmail(email);
        return this;
    }

    public ClienteEntityBuilder withPassword(String password) {
        clienteEntity.setPassword(password);
        return this;
    }

    public ClienteEntityBuilder withCpf(Long cpf) {
        clienteEntity.setCpf(cpf);
        return this;
    }

    public ClienteEntityBuilder withTelefoneRes(String telefoneRes) {
        clienteEntity.setTelefoneRes(telefoneRes);
        return this;
    }

    public ClienteEntityBuilder withTelefoneCom(String telefoneCom) {
        clienteEntity.setTelefoneCom(telefoneCom);
        return this;
    }

    public ClienteEntityBuilder withTelefoneCel(String telefoneCel) {
        clienteEntity.setTelefoneCel(telefoneCel);
        return this;
    }

    public ClienteEntityBuilder withNumCartao(Long numCartao) {
        clienteEntity.setNumCartao(numCartao);
        return this;
    }

    public ClienteEntityBuilder withDataValidade(Date dataValidade) {
        clienteEntity.setDataValidade(dataValidade);
        return this;
    }

    public ClienteEntityBuilder withNomeCartao(String nomeCartao) {
        clienteEntity.setNomeCartao(nomeCartao);
        return this;
    }

    public ClienteEntityBuilder withCVV(Integer cvv) {
        clienteEntity.setCVV(cvv);
        return this;
    }

    public ClienteEntityBuilder withEnderecoResidencial(EnderecoEntity enderecoResidencial) {
        clienteEntity.setEnderecoResidencial(enderecoResidencial);
        return this;
    }

    public ClienteEntityBuilder withEnderecoCobraca(EnderecoEntity enderecoCobraca) {
        clienteEntity.setEnderecoCobraca(enderecoCobraca);
        return this;
    }

    public ClienteEntityBuilder withEnderecoComercial(EnderecoEntity enderecoComercial) {
        clienteEntity.setEnderecoComercial(enderecoComercial);
        return this;
    }

    public ClienteEntity build() {
        return clienteEntity;
    }
}
