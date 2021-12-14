package br.iesb.store.virtualstore.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "Produto")
public class ProdutoEntity extends PrincipalEntity {

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descrisao",nullable = false)
    private String descricao;

    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    public ProdutoEntity() {}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ProdutoEntity{" +
                "code='" + code + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProdutoEntity that = (ProdutoEntity) o;
        return Objects.equals(code, that.code) && Objects.equals(nome, that.nome) && Objects.equals(descricao, that.descricao) && Objects.equals(preco, that.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), code, nome, descricao, preco);
    }
}
