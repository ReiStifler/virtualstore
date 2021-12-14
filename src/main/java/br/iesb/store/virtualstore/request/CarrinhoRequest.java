package br.iesb.store.virtualstore.request;

public class CarrinhoRequest {

    private Long produtoId;
    private Integer quantidade;

    public Long getProdutoId() {
        return produtoId;
    }

    public Integer getQuantidade() {
        if (quantidade <= 0) {
            return 1;
        }

        return quantidade;
    }
}
