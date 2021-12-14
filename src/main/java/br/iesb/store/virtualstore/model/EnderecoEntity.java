package br.iesb.store.virtualstore.model;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "Endereco")
@Entity
public class EnderecoEntity extends PrincipalEntity {

    @Column(name = "CEP", nullable = false)
    private String cep;

    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "endereco",nullable = false)
    private String endereco;

    @Column(name = "complemento")
    private String complemento;

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

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "EnderecoEntity{" +
                "cep='" + cep + '\'' +
                ", numero=" + numero +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoEntity that = (EnderecoEntity) o;
        return Objects.equals(cep, that.cep) && Objects.equals(numero, that.numero) && Objects.equals(endereco, that.endereco) && Objects.equals(complemento, that.complemento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, numero, endereco, complemento);
    }
}
