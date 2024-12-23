package github.samuelmaia1.CriandoProjetoSpringBoot.controller;

import github.samuelmaia1.CriandoProjetoSpringBoot.model.Product;
import github.samuelmaia1.CriandoProjetoSpringBoot.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        repository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado")));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
