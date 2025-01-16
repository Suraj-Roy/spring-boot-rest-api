package com.example2.example2.service;

import java.util.List;

import com.example2.example2.dto.ProductDto;

public interface ProductService {

    public Boolean saveProduct(ProductDto productDto);

    public List<ProductDto> getAllProduct();

    public ProductDto getProductById(Long id);

    public Boolean deleteProductById(Long id);

}
