package br.iesb.store.virtualstore.controller;

import br.iesb.store.virtualstore.dto.ProdutoDTO;
import br.iesb.store.virtualstore.request.ProdutoRequest;
import br.iesb.store.virtualstore.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/create") // http://localhost:8080/produtos/create
    public ResponseEntity<String> create(@RequestBody ProdutoRequest produtoRequest) {

        int ret = produtoService.create(produtoRequest);

        return new ResponseEntity<>(String.format("Produto Cadastrado Com {ID; %s}", ret), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}") // http://localhost:8080/produtos/update/id
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody ProdutoRequest produtoRequest) {

        int ret = produtoService.update(id, produtoRequest);

        if (ret == -1) {
            return new ResponseEntity<>("Produto Não Existe", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(String.format("Produto Alterado Com Sucesso De {ID; %s}", ret), HttpStatus.OK);
    }

    @GetMapping ("/{id}") // http://localhost:8080/produtos/id
    public ResponseEntity<ProdutoDTO> get(@PathVariable Long id) {

        ProdutoDTO produto = produtoService.get(id);

        if (produto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}") // http://localhost:8080/produtos/delete/id
    public ResponseEntity<String> delete(@PathVariable Long id) {

        int ret = produtoService.delete(id);

        if (ret == -1) {
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        } else if (ret == -2) {
            return new ResponseEntity<>("Produto Em Compra", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Produto Deletado Com Sucesso", HttpStatus.OK);
        }
    }
}
