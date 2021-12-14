package br.iesb.store.virtualstore.controller;

import br.iesb.store.virtualstore.dto.CarrinhoDTO;
import br.iesb.store.virtualstore.request.CarrinhoRequest;
import br.iesb.store.virtualstore.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping("/add") // POST http://localhost:8080/carrinho/add?clienteId=idCliente
    public ResponseEntity<?> add(@RequestParam Long clienteId, @RequestBody CarrinhoRequest carrinhoRequest) {

        int ret = carrinhoService.add(clienteId, carrinhoRequest);

        if (ret == -1) {
            return new ResponseEntity<>("Nao Ta Authenticado", HttpStatus.UNAUTHORIZED);
        } else if (ret == -2){
            return new ResponseEntity<>("Produto Não Existe", HttpStatus.NOT_FOUND);
        } else if (ret == -3) {
            return new ResponseEntity<>("Produto Já Está No Carrinho", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Adicionado Com Sucesso", HttpStatus.OK);
        }
    }

    @PutMapping("/update") // PUT http://localhost:8080/carrinho/update/id?clienteId=idCliente
    public ResponseEntity<?> update(@RequestParam Long clienteId, @RequestBody CarrinhoRequest carrinhoRequest) {
        int ret = carrinhoService.update(clienteId, carrinhoRequest);

        if (ret == -1) {
            return new ResponseEntity<>("Nao Ta Authenticado", HttpStatus.UNAUTHORIZED);
        } else if (ret == -2){
            return new ResponseEntity<>("Produto Não Existe", HttpStatus.NOT_FOUND);
        } else if (ret == -3) {
            return new ResponseEntity<>("Produto Já Está No Carrinho", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Alterado Com Sucesso", HttpStatus.OK);
        }
    }

    @GetMapping("/get") // GET http://localhost:8080/carrinho/get?clienteId=idCliente
    public ResponseEntity<CarrinhoDTO> get(@RequestParam Long clienteId) {

        CarrinhoDTO carrinho = carrinhoService.get(clienteId);

        return new ResponseEntity<>(carrinho, HttpStatus.OK);
    }

    @DeleteMapping("/delete") // DELETE http://localhost:8080/carrinho/delete?clienteId=idCliente
    public ResponseEntity<?> delete(@RequestParam Long clienteId, @RequestBody CarrinhoRequest carrinhoRequest) {
        int ret = carrinhoService.delete(clienteId, carrinhoRequest);

        if (ret == -1) {
            return new ResponseEntity<>("Nao Ta Authenticado", HttpStatus.UNAUTHORIZED);
        } else if (ret == -2){
            return new ResponseEntity<>("Produto Não Existe", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>("Alterado Com Sucesso", HttpStatus.OK);
        }
    }

    @DeleteMapping("/clear") // DELETE http://localhost:8080/carrinho/clear?clienteId=idCliente
    public ResponseEntity<?> clear(@RequestParam Long clienteId) {

        int ret = carrinhoService.clear(clienteId);

        return new ResponseEntity<>("Carrinho Foi Deletado Com Sucesso", HttpStatus.OK);
    }
}

/**
 *
 {
 totalItem: 10,
 valorTotal: 10000,
 itens: [
 {"produto": "Suco", "quantidade": 2, "preco": 1.99, "total": 3.98},
 {"produto": "Suco", "quantidade": 2, "preco": 1.99, "total": 3.98},
 {"produto": "Suco", "quantidade": 2, "preco": 1.99, "total": 3.98}
 ]
 }
 *
 */
