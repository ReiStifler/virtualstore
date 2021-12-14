package br.iesb.store.virtualstore.dto;

import br.iesb.store.virtualstore.model.ClienteEntity;

public class ClienteDTO {

    private String nome;
    private String email;
    private Long cpf;
    private String telefoneRes;
    private String telefoneCom;
    private String telefoneCel;
    private EnderecoDTO end_comercial;
    private EnderecoDTO end_residencial;

    public ClienteDTO(ClienteEntity clienteEntity) {
        this.nome = clienteEntity.getNome();
        this.email = clienteEntity.getEmail();
        this.cpf = clienteEntity.getCpf();
        this.telefoneRes = clienteEntity.getTelefoneRes();
        this.telefoneCom = clienteEntity.getTelefoneCom();
        this.telefoneCel = clienteEntity.getTelefoneCel();
        this.end_comercial = new EnderecoDTO(clienteEntity.getEnderecoComercial());
        this.end_residencial = new EnderecoDTO(clienteEntity.getEnderecoResidencial());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getTelefoneRes() {
        return telefoneRes;
    }

    public void setTelefoneRes(String telefoneRes) {
        this.telefoneRes = telefoneRes;
    }

    public String getTelefoneCom() {
        return telefoneCom;
    }

    public void setTelefoneCom(String telefoneCom) {
        this.telefoneCom = telefoneCom;
    }

    public String getTelefoneCel() {
        return telefoneCel;
    }

    public void setTelefoneCel(String telefoneCel) {
        this.telefoneCel = telefoneCel;
    }

    public EnderecoDTO getEnd_comercial() {
        return end_comercial;
    }

    public void setEnd_comercial(EnderecoDTO end_comercial) {
        this.end_comercial = end_comercial;
    }

    public EnderecoDTO getEnd_residencial() {
        return end_residencial;
    }

    public void setEnd_residencial(EnderecoDTO end_residencial) {
        this.end_residencial = end_residencial;
    }
}
