package br.iesb.store.virtualstore.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table
public class CarrinhoItemEntity extends PrincipalEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "carrinho_id", nullable = false)
    private CarrinhoEntity carrinho;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProdutoEntity produto;

    private Integer quantidade;

    private BigDecimal preco;

    public CarrinhoItemEntity() {}

    public CarrinhoEntity getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoEntity carrinho) {
        this.carrinho = carrinho;
    }

    public ProdutoEntity getProduto() {
        return produto;
    }

    public void setProduto(ProdutoEntity produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "CarrinhoItemEntity{" +
                "carrinho=" + carrinho +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarrinhoItemEntity that = (CarrinhoItemEntity) o;
        return Objects.equals(carrinho, that.carrinho) && Objects.equals(produto, that.produto) && Objects.equals(quantidade, that.quantidade) && Objects.equals(preco, that.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carrinho, produto, quantidade, preco);
    }
}
