package br.iesb.store.virtualstore.repository;

import br.iesb.store.virtualstore.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    Boolean existsByCpf(Long cpf);

    Boolean existsByEmailIgnoreCase(String email);
}
