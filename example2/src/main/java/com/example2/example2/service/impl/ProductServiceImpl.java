package com.example2.example2.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example2.example2.dto.ProductDto;
import com.example2.example2.exception.ResourceNotFoundException;
import com.example2.example2.model.Product;
import com.example2.example2.repository.ProductRepository;
import com.example2.example2.service.ProductService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    @Override
    public void deleteProductById(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Product not found with ID: " + id);
        }
    }


    @Override
    public List<ProductDto> getAllProduct() {

        List<Product> products = productRepository.findAll();

        if (products.isEmpty()) {
            throw new ResourceNotFoundException("No product found in records");
        }

        return products.stream()
                    .map(product -> mapper.map(product, ProductDto.class))
                    .collect(Collectors.toList());
    }


    @Override
    public ProductDto getProductById(Long id) {
        Objects.requireNonNull(id, "Product ID must not be null");

        return productRepository.findById(id)
                .map(product -> mapper.map(product, ProductDto.class))
                .orElseThrow(() -> new ResourceNotFoundException(String.format("No product found with ID: %s", id)));
    }


    @Override
    public Boolean saveProduct(ProductDto productDto) {
        Product product = mapper.map(productDto, Product.class);
        product = productRepository.save(product);
        return product != null;
    }


    

}
