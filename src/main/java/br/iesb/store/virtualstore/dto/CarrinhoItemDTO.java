package br.iesb.store.virtualstore.dto;

import br.iesb.store.virtualstore.model.CarrinhoItemEntity;

import java.math.BigDecimal;

public class CarrinhoItemDTO {

    private String produto;
    private Integer quantidade;
    private BigDecimal preco;
    private BigDecimal total;

    public CarrinhoItemDTO(CarrinhoItemEntity item) {
        produto = item.getProduto().getNome();
        quantidade = item.getQuantidade();
        preco = item.getPreco();
        total = BigDecimal.valueOf(quantidade.doubleValue() * preco.doubleValue());
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
