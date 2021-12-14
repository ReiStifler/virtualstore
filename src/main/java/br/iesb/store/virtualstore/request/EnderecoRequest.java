package br.iesb.store.virtualstore.request;

public class EnderecoRequest {
    private String cep;
    private Integer numero;
    private String endereco;
    private String complemento;

    public String getCep() {
        return cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }
}
