package br.iesb.store.virtualstore.dto;

import br.iesb.store.virtualstore.model.ProdutoEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProdutoDTO {
    private String nome;
    private String cod_prod;
    private BigDecimal valor_prod;
    private String descrissao_prod;

    public ProdutoDTO(ProdutoEntity produto) {
        this.nome = produto.getNome();
        this.cod_prod = produto.getCode();
        this.valor_prod = produto.getPreco(); //.setScale(3, RoundingMode.UNNECESSARY);
        this.descrissao_prod = produto.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(String cod_prod) {
        this.cod_prod = cod_prod;
    }

    public BigDecimal getValor_prod() {
        return valor_prod;
    }

    public void setValor_prod(BigDecimal valor_prod) {
        this.valor_prod = valor_prod;
    }

    public String getDescrissao_prod() {
        return descrissao_prod;
    }

    public void setDescrissao_prod(String descrissao_prod) {
        this.descrissao_prod = descrissao_prod;
    }
}
