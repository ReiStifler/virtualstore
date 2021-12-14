package br.iesb.store.virtualstore.controller;

import br.iesb.store.virtualstore.dto.ClienteDTO;
import br.iesb.store.virtualstore.request.ClienteRequest;
import br.iesb.store.virtualstore.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/create") // POST: http://localhost:8080/clientes/create
    public ResponseEntity<String> save(@RequestBody ClienteRequest clienteRequest) {
        int ret = clienteService.save(clienteRequest);

        if (ret == -1) {
            return new ResponseEntity<>("Email Fora Do Padrão", HttpStatus.BAD_REQUEST);
        } else if (ret == -2) {
            return new ResponseEntity<>("Senha Fora Do Padrão", HttpStatus.BAD_REQUEST);
        } else if (ret == -3) {
            return new ResponseEntity<>("Já Existe Usuário Com Esse CPF", HttpStatus.BAD_REQUEST);
        } else if (ret == -4) {
            return new ResponseEntity<>("Já Existe Usuário Com Esse Email", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(String.format("Cliente Adicionado Com Sucesso Com {ID: %s}", ret), HttpStatus.CREATED);
        }
    }

    @PutMapping("/update/{id}") // PUT: http://localhost:8080/clientes/update/id
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody ClienteRequest clienteRequest) {

        int ret = clienteService.update(id, clienteRequest);

        if (ret == -1) {
            return new ResponseEntity<>("Cliente Não Existe", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(String.format("Cliente Alterado Com Sucesso Com {ID: %s}", ret), HttpStatus.OK);
        }
    }

    @GetMapping("/{id}") // GET: http://localhost:8080/clientes/id
    public ResponseEntity<ClienteDTO> get(@PathVariable Long id) {
        ClienteDTO cliente = clienteService.get(id);

        if (cliente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}") // DELETE: http://localhost:8080/clientes/delete/id
    public ResponseEntity<String> delete(@PathVariable Long id) {

        boolean ret = clienteService.delete(id);

        if (!ret) {
            return new ResponseEntity<>("Cliente Não Existe", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Cliente Deletado Com Sucesso", HttpStatus.OK);
    }
}
