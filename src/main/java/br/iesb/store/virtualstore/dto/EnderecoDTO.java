package br.iesb.store.virtualstore.dto;

import br.iesb.store.virtualstore.model.EnderecoEntity;

public class EnderecoDTO {

    private String cep;
    private Integer numero;
    private String endereco;
    private String complemento;

    public EnderecoDTO(EnderecoEntity enderecoEntity) {
        this.cep = enderecoEntity.getCep();
        this.numero = enderecoEntity.getNumero();
        this.endereco = enderecoEntity.getEndereco();
        this.complemento = enderecoEntity.getComplemento();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
