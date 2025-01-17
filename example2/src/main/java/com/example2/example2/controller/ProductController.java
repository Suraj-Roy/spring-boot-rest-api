package com.example2.example2.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example2.example2.dto.ProductDto;
import com.example2.example2.service.ProductService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody @Valid ProductDto productDto){
        Boolean isSaved = productService.saveProduct(productDto);
        if(!isSaved){
            return new ResponseEntity<>("product not saved", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<>("saved sucessfully", HttpStatus.CREATED);
    }

    @GetMapping("get-all-products")
    public ResponseEntity<?> getAllProducts(){
        List<ProductDto> productsList = productService.getAllProduct();
        if(CollectionUtils.isEmpty(productsList)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(productsList, HttpStatus.OK);
    }

    @GetMapping("/get-product")
    public ResponseEntity<?> getProduct(@RequestParam Long id){
        ProductDto product = productService.getProductById(id);
        

        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @DeleteMapping("delete-product")
    public ResponseEntity<?> deleteProduct(@RequestParam Long id){
       productService.deleteProductById(id);
       return new ResponseEntity<>("product deleted sucessfully",HttpStatus.OK);
    }    

}
