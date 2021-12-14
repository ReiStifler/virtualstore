package br.iesb.store.virtualstore.service;

import br.iesb.store.virtualstore.dto.ClienteDTO;
import br.iesb.store.virtualstore.model.CarrinhoEntity;
import br.iesb.store.virtualstore.model.ClienteEntity;
import br.iesb.store.virtualstore.model.EnderecoEntity;
import br.iesb.store.virtualstore.model.builder.CarrinhoEntityBuilder;
import br.iesb.store.virtualstore.model.builder.ClienteEntityBuilder;
import br.iesb.store.virtualstore.model.builder.EnderecoEntityBuilder;
import br.iesb.store.virtualstore.repository.ClienteRepository;
import br.iesb.store.virtualstore.request.ClienteRequest;
import br.iesb.store.virtualstore.validation.EmailValidator;
import br.iesb.store.virtualstore.validation.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public int save(ClienteRequest clienteRequest) {

        if (!EmailValidator.isValid(clienteRequest.getEmail())) {
            return -1;
        }

        if (!PasswordValidator.isValid(clienteRequest.getPassword())) {
            return -2;
        }

        if (clienteRepository.existsByCpf(clienteRequest.getCpf())) {
            return -3;
        }

        if (clienteRepository.existsByEmailIgnoreCase(clienteRequest.getEmail())) {
            return -4;
        }

        EnderecoEntity enderecoResidencial = EnderecoEntityBuilder.builder()
                .withCep(clienteRequest.getEnderecoResidencial().getCep())
                .withNumero(clienteRequest.getEnderecoResidencial().getNumero())
                .withEndereco(clienteRequest.getEnderecoResidencial().getEndereco())
                .withComplemento(clienteRequest.getEnderecoResidencial().getComplemento())
                .build();

        EnderecoEntity enderecoCobranca = EnderecoEntityBuilder.builder()
                .withCep(clienteRequest.getEnderecoCobranca().getCep())
                .withNumero(clienteRequest.getEnderecoCobranca().getNumero())
                .withEndereco(clienteRequest.getEnderecoCobranca().getEndereco())
                .withComplemento(clienteRequest.getEnderecoCobranca().getComplemento())
                .build();

        EnderecoEntity enderecoComercial = EnderecoEntityBuilder.builder()
                .withCep(clienteRequest.getEnderecoComercial().getCep())
                .withNumero(clienteRequest.getEnderecoComercial().getNumero())
                .withEndereco(clienteRequest.getEnderecoComercial().getEndereco())
                .withComplemento(clienteRequest.getEnderecoComercial().getComplemento())
                .build();


        ClienteEntity clienteEntity = ClienteEntityBuilder.builder()
                .withNome(clienteRequest.getNome())
                .withEmail(clienteRequest.getEmail())
                .withCpf(clienteRequest.getCpf())
                .withPassword(clienteRequest.getPassword())
                .withTelefoneCel(clienteRequest.getTelefoneCel())
                .withTelefoneCom(clienteRequest.getTelefoneCom())
                .withTelefoneRes(clienteRequest.getTelefoneRes())
                .withCVV(clienteRequest.getCvv())
                .withNomeCartao(clienteRequest.getNomePessoaCartao())
                .withNumCartao(clienteRequest.getNumCartao())
                .withDataValidade(clienteRequest.getDataValidade())
                .withEnderecoResidencial(enderecoResidencial)
                .withEnderecoComercial(enderecoComercial)
                .withEnderecoCobraca(enderecoCobranca)
                .build();

        CarrinhoEntity carrinho = CarrinhoEntityBuilder.builder()
                .withCliente(clienteEntity)
                .build();

        clienteEntity.setCarrinho(carrinho);

        clienteEntity = clienteRepository.save(clienteEntity);

        return clienteEntity.getId().intValue();
    }

    public int update(Long id, ClienteRequest clienteRequest) {
        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(id);

        if (clienteEntity.isEmpty()) {
            return -1;
        }

        ClienteEntity cliente = clienteEntity.get();

        cliente.setNome(clienteRequest.getNome());
        cliente.setTelefoneCel(clienteRequest.getTelefoneCel());
        cliente.setTelefoneCom(clienteRequest.getTelefoneCom());
        cliente.setTelefoneRes(clienteRequest.getTelefoneRes());

        clienteRepository.save(cliente);

        return cliente.getId().intValue();
    }

    public ClienteDTO get(Long id) {
        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(id);

        if (clienteEntity.isEmpty()) {
            return null;
        }

        return new ClienteDTO(clienteEntity.get());
    }

    public boolean delete(Long id) {
        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(id);

        if (clienteEntity.isEmpty()) {
            return false;
        }

        clienteRepository.delete(clienteEntity.get());
        return true;
    }
}
