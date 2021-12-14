package br.iesb.store.virtualstore.repository;

import br.iesb.store.virtualstore.model.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}
