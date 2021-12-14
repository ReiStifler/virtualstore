package br.iesb.store.virtualstore.service;

import br.iesb.store.virtualstore.dto.ProdutoDTO;
import br.iesb.store.virtualstore.model.ProdutoEntity;
import br.iesb.store.virtualstore.model.builder.ProdutoEntityBuilder;
import br.iesb.store.virtualstore.repository.ProdutoRepository;
import br.iesb.store.virtualstore.request.ProdutoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public int create(ProdutoRequest produtoRequest) {

        ProdutoEntity produto = ProdutoEntityBuilder.builder()
                .withCode(produtoRequest.getCode())
                .withNome(produtoRequest.getNome())
                .withDescricao(produtoRequest.getDescricao())
                .withPreco(produtoRequest.getPreco())
                .build();

        produto = produtoRepository.save(produto);

        return produto.getId().intValue();
    }

    public int update(Long id, ProdutoRequest produtoRequest) {

        Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(id);

        if (produtoEntity.isEmpty()) {
            return -1;
        }

        ProdutoEntity produto = produtoEntity.get();

        produto.setPreco(produtoRequest.getPreco());
        produtoRepository.save(produto);

        return produto.getId().intValue();
    }

    public ProdutoDTO get(Long id) {
        Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(id);

        if (produtoEntity.isEmpty()) {
            return null;
        }

        return new ProdutoDTO(produtoEntity.get());
    }

    public int delete(Long id) {
        Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(id);

        if (produtoEntity.isEmpty()) {
            return -1;
        }

        // @TODO Verifica Se O Produto Já Esta Em Uma Compra

//        if () {
//            return -2;
//        }

        produtoRepository.delete(produtoEntity.get());

        return 0;
    }
}
