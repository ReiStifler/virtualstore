package br.iesb.store.virtualstore.service;

import br.iesb.store.virtualstore.dto.CarrinhoDTO;
import br.iesb.store.virtualstore.model.CarrinhoEntity;
import br.iesb.store.virtualstore.model.CarrinhoItemEntity;
import br.iesb.store.virtualstore.model.ClienteEntity;
import br.iesb.store.virtualstore.model.ProdutoEntity;
import br.iesb.store.virtualstore.model.builder.CarrinhoItemEntityBuilder;
import br.iesb.store.virtualstore.repository.CarrinhoItemRepository;
import br.iesb.store.virtualstore.repository.CarrinhoRepository;
import br.iesb.store.virtualstore.repository.ClienteRepository;
import br.iesb.store.virtualstore.repository.ProdutoRepository;
import br.iesb.store.virtualstore.request.CarrinhoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private CarrinhoItemRepository carrinhoItemRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public int add(Long clienteId, CarrinhoRequest carrinhoRequest) {

        // @TODO verifica se o cliente esta logado

        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(clienteId);

        if (clienteEntity.isEmpty()) {
            return -1;
        }

        ClienteEntity cliente = clienteEntity.get();

        CarrinhoEntity carrinho = cliente.getCarrinho();

        Optional<ProdutoEntity> produto = produtoRepository.findById(carrinhoRequest.getProdutoId());

        if (produto.isEmpty()) {
            return -2;
        }

        if (carrinhoItemRepository.existsByCarrinhoAndProduto(carrinho, produto.get())) {
            return -3;
        }

        CarrinhoItemEntity novoCarrinhoItem = CarrinhoItemEntityBuilder.builder()
                .withCarrinho(carrinho)
                .withProduto(produto.get())
                .withQuantidade(carrinhoRequest.getQuantidade())
                .withPreco(produto.get().getPreco())
                .build();


        carrinho.getItens().add(novoCarrinhoItem);

        carrinhoRepository.save(carrinho);

        return 0;
    }

    public int update(Long clienteId, CarrinhoRequest carrinhoRequest) {

        ClienteEntity cliente = clienteRepository.getById(clienteId);

        CarrinhoEntity carrinho = cliente.getCarrinho();

        Optional<ProdutoEntity> produto = produtoRepository.findById(carrinhoRequest.getProdutoId());

        if (produto.isEmpty()) {
            return -2;
        }

        Optional<CarrinhoItemEntity> itemEntity = carrinhoItemRepository.findByCarrinhoAndProduto(carrinho, produto.get());

        if (itemEntity.isEmpty()) {
            return -3;
        }

        CarrinhoItemEntity item = itemEntity.get();

        item.setQuantidade(carrinhoRequest.getQuantidade());

        carrinhoItemRepository.save(item);

        return 0;
    }

    public int clear(Long clienteId) {

        ClienteEntity cliente = clienteRepository.getById(clienteId);

        CarrinhoEntity carrinho = cliente.getCarrinho();

        if (carrinho.getItens().size() > 0) {
            carrinho.getItens().clear();
            cliente.getCarrinho().setItens(carrinho.getItens());
            cliente = clienteRepository.save(cliente);
        }

        return 0;
    }

    public CarrinhoDTO get(Long clienteId) {

        ClienteEntity cliente = clienteRepository.getById(clienteId);

        CarrinhoEntity carrinho = cliente.getCarrinho();

        return new CarrinhoDTO(carrinho);
    }

    public int delete(Long clienteId, CarrinhoRequest carrinhoRequest) {
        ClienteEntity cliente = clienteRepository.getById(clienteId);

        CarrinhoEntity carrinho = cliente.getCarrinho();

        Optional<ProdutoEntity> produto = produtoRepository.findById(carrinhoRequest.getProdutoId());

        if (produto.isEmpty()) {
            return -2;
        }

        Optional<CarrinhoItemEntity> itemEntity = carrinhoItemRepository.findByCarrinhoAndProduto(carrinho, produto.get());

        if (itemEntity.isEmpty()) {
            return -2;
        }

        CarrinhoItemEntity item = itemEntity.get();

        carrinhoItemRepository.delete(item);

        return 0;
    }
}
