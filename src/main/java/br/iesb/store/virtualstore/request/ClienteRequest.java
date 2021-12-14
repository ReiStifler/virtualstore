package br.iesb.store.virtualstore.request;

import java.util.Date;

public class ClienteRequest {

    private String nome;
    private String email;
    private Long cpf;
    private String telefoneRes;
    private String telefoneCom;
    private String telefoneCel;
    private Long numCartao;
    private Integer cvv;
    private String nomePessoaCartao;
    private Date dataValidade;
    private EnderecoRequest enderecoResidencial;
    private EnderecoRequest enderecoComercial;
    private EnderecoRequest enderecoCobranca;
    private String password;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getTelefoneRes() {
        return telefoneRes;
    }

    public String getTelefoneCom() {
        return telefoneCom;
    }

    public String getTelefoneCel() {
        return telefoneCel;
    }

    public Long getNumCartao() {
        return numCartao;
    }

    public Integer getCvv() {
        return cvv;
    }

    public String getNomePessoaCartao() {
        return nomePessoaCartao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public EnderecoRequest getEnderecoResidencial() {
        return enderecoResidencial;
    }

    public EnderecoRequest getEnderecoComercial() {
        return enderecoComercial;
    }

    public EnderecoRequest getEnderecoCobranca() {
        return enderecoCobranca;
    }

    public String getPassword() {
        return password;
    }
}
