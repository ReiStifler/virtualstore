package br.iesb.store.virtualstore.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Table(name = "Cliente")
@Entity
public class ClienteEntity extends PrincipalEntity {

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "cpf", nullable = false)
    private Long cpf;

    @Column(name = "telefone_res", nullable = false)
    private String telefoneRes;

    @Column(name = "telefone_com", nullable = false)
    private String telefoneCom;

    @Column(name = "telefone_cel", nullable = false)
    private String telefoneCel;

    @Column(name = "num_cartao", nullable = false)
    private Long numCartao;

    @Column(name = "data_validade", nullable = false)
    private Date dataValidade;

    @Column(name = "nome_cartao", nullable = false)
    private String nomeCartao;

    @Column(name = "CVV", nullable = false)
    private Integer cvv;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_residencial", referencedColumnName = "id")
    private EnderecoEntity enderecoResidencial;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_comercial", referencedColumnName = "id")
    private EnderecoEntity enderecoComercial;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_entrega", referencedColumnName = "id")
    private EnderecoEntity enderecoEntrega;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_cobranca", referencedColumnName = "id")
    private EnderecoEntity enderecoCobraca;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CarrinhoEntity carrinho;

    public ClienteEntity() {
    } //construtor

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

    public Long getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(Long numCartao) {
        this.numCartao = numCartao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public Integer getCVV() {
        return cvv;
    }

    public void setCVV(Integer CVV) {
        this.cvv = CVV;
    }

    public EnderecoEntity getEnderecoResidencial() {
        return enderecoResidencial;
    }

    public void setEnderecoResidencial(EnderecoEntity enderecoResidencial) {
        this.enderecoResidencial = enderecoResidencial;
    }

    public EnderecoEntity getEnderecoComercial() {
        return enderecoComercial;
    }

    public void setEnderecoComercial(EnderecoEntity enderecoComercial) {
        this.enderecoComercial = enderecoComercial;
    }

    public EnderecoEntity getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(EnderecoEntity enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public EnderecoEntity getEnderecoCobraca() {
        return enderecoCobraca;
    }

    public void setEnderecoCobraca(EnderecoEntity enderecoCobraca) {
        this.enderecoCobraca = enderecoCobraca;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CarrinhoEntity getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoEntity carrinho) {
        this.carrinho = carrinho;
    }

    @Override
    public String toString() {
        return "ClienteEntity{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cpf=" + cpf +
                ", telefoneRes='" + telefoneRes + '\'' +
                ", telefoneCom='" + telefoneCom + '\'' +
                ", telefoneCel='" + telefoneCel + '\'' +
                ", numCartao=" + numCartao +
                ", dataValidade=" + dataValidade +
                ", nomeCartao='" + nomeCartao + '\'' +
                ", CVV=" + cvv +
                '}';

    }

    @Override
    public boolean equals(Object o) {// verifica se ha iguais
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity that = (ClienteEntity) o;
        return Objects.equals(nome, that.nome) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(cpf, that.cpf) && Objects.equals(telefoneRes, that.telefoneRes) && Objects.equals(telefoneCom, that.telefoneCom) && Objects.equals(telefoneCel, that.telefoneCel) && Objects.equals(numCartao, that.numCartao) && Objects.equals(dataValidade, that.dataValidade) && Objects.equals(nomeCartao, that.nomeCartao) && Objects.equals(cvv, that.cvv) && Objects.equals(enderecoResidencial, that.enderecoResidencial) && Objects.equals(enderecoComercial, that.enderecoComercial) && Objects.equals(enderecoEntrega, that.enderecoEntrega) && Objects.equals(enderecoCobraca, that.enderecoCobraca) && Objects.equals(carrinho, that.carrinho);
    }

    @Override
    public int hashCode() { //codigo unico para cada instancia
        return Objects.hash(nome, email, password, cpf, telefoneRes, telefoneCom, telefoneCel, numCartao, dataValidade, nomeCartao, cvv, enderecoResidencial, enderecoComercial, enderecoEntrega, enderecoCobraca, carrinho);
    }
}

