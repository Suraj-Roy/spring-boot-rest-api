package com.example2.example2.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example2.example2.dto.ProductDto;
import com.example2.example2.service.ProductService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDto productDto){
        try {
            Boolean isSaved = productService.saveProduct(productDto);
            if(!isSaved){
                return new ResponseEntity<>("product not saved", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<>("saved sucessfully", HttpStatus.CREATED);
    }

    @GetMapping("get-all-products")
    public ResponseEntity<?> getAllProducts(){
        List<ProductDto> productsList = null;
        try {
            productsList = productService.getAllProduct();
            if(CollectionUtils.isEmpty(productsList)){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(productsList, HttpStatus.OK);
    }

    @GetMapping("/get-product")
    public ResponseEntity<?> getProduct(@RequestParam Long id){
        ProductDto product = null;
        try {
            product = productService.getProductById(id);
            if(ObjectUtils.isEmpty(product)){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @DeleteMapping("delete-product")
    public ResponseEntity<?> deleteProduct(@RequestParam Long id){
        try {
            Boolean isDeleted = productService.deleteProductById(id);
            if(!isDeleted){
                return new ResponseEntity<>("product not deleted", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("product deleted sucessfully",HttpStatus.OK);
    }    

}
