package br.iesb.store.virtualstore.repository;

import br.iesb.store.virtualstore.model.CarrinhoEntity;
import br.iesb.store.virtualstore.model.CarrinhoItemEntity;
import br.iesb.store.virtualstore.model.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarrinhoItemRepository extends JpaRepository<CarrinhoItemEntity, Long> {

    Boolean existsByCarrinhoAndProduto(CarrinhoEntity carrinho, ProdutoEntity produto);

    Optional<CarrinhoItemEntity> findByCarrinhoAndProduto(CarrinhoEntity carrinho, ProdutoEntity produto);
}
