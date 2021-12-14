package br.iesb.store.virtualstore.dto;

import br.iesb.store.virtualstore.model.CarrinhoEntity;
import br.iesb.store.virtualstore.model.CarrinhoItemEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDTO {

    private Integer totalItens;
    private BigDecimal valorTotal;
    private List<CarrinhoItemDTO> itens;

    public CarrinhoDTO() {}

    public CarrinhoDTO(CarrinhoEntity carrinho) {
        this.totalItens = carrinho.getItens().size();
        this.valorTotal = getCarrinhoValorTotal(carrinho.getItens());
        this.itens = getCarrinhoItens(carrinho.getItens());
    }

    public Integer getTotalItens() {
        return totalItens;
    }

    public void setTotalItens(Integer totalItens) {
        this.totalItens = totalItens;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<CarrinhoItemDTO> getItens() {
        return itens;
    }

    public void setItens(List<CarrinhoItemDTO> itens) {
        this.itens = itens;
    }

    private List<CarrinhoItemDTO> getCarrinhoItens(List<CarrinhoItemEntity> itens) {
        List<CarrinhoItemDTO> itensDTO = new ArrayList<>();

        for (CarrinhoItemEntity item: itens) {
            CarrinhoItemDTO itemDTO = new CarrinhoItemDTO(item);

            itensDTO.add(itemDTO);
        }

        return itensDTO;
    }

    private BigDecimal getCarrinhoValorTotal(List<CarrinhoItemEntity> itens) {

        double valorTotal = 0;

        for (CarrinhoItemEntity item: itens) {
            valorTotal += item.getQuantidade().doubleValue() * item.getPreco().doubleValue();
        }

        return BigDecimal.valueOf(valorTotal).setScale(3, RoundingMode.UP);
    }
}
