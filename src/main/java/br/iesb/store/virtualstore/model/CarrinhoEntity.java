package br.iesb.store.virtualstore.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class CarrinhoEntity extends PrincipalEntity {

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", nullable = false, referencedColumnName = "id")
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "carrinho", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CarrinhoItemEntity> itens;

    public CarrinhoEntity() {}  //Construtor

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public List<CarrinhoItemEntity> getItens() {
        return itens;
    }

    public void setItens(List<CarrinhoItemEntity> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "CarrinhoEntity{" +
                "cliente=" + cliente +
                ", itens=" + itens +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarrinhoEntity carrinho = (CarrinhoEntity) o;
        return Objects.equals(cliente, carrinho.cliente) && Objects.equals(itens, carrinho.itens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, itens);
    }
}
