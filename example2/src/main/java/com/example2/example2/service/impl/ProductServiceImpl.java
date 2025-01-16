package com.example2.example2.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example2.example2.dto.ProductDto;
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
    public Boolean deleteProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);

        if(product.isPresent()){
            productRepository.delete(product.get());
            return true;
        }
        return false;
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDtoList  = productList.stream()
                                                    .map(product -> mapper.map(product, ProductDto.class))
                                                    .collect(Collectors.toList());
        return productDtoList;
    }

    @Override
    public ProductDto getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return mapper.map(product.get(), ProductDto.class);
        }
        return null;
    }

    @Override
    public Boolean saveProduct(ProductDto productDto) {
        Product product = productRepository.save(mapper.map(productDto, Product.class));
        if(ObjectUtils.isEmpty(product)){
            return false;
        }
        return true;
    }

    

}
