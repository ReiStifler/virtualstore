package br.iesb.store.virtualstore.repository;

import br.iesb.store.virtualstore.model.CarrinhoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<CarrinhoEntity, Long> {
}
