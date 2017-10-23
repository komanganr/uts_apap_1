package com.example.uts1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uts1.dao.ProductMapper;
import com.example.uts1.model.ProductModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceDB implements ProductService {
	@Autowired
    private ProductMapper productMapper;

	@Override
	public List<ProductModel> viewAllProduct() {
		log.info ("view all products");
        return productMapper.viewAllProduct ();
	}
	
	@Override
	public ProductModel selectProduk(int id) {
		log.info ("select produk with id {}", id);
        return productMapper.selectProduk (id);
	}

	@Override
	public void updateProduk(ProductModel produk) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addProduk(ProductModel produk) {
		productMapper.addProduk (produk);
	}

}
