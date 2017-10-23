package com.example.uts1.service;

import java.util.List;

import com.example.uts1.model.ProductModel;

public interface ProductService {
	List<ProductModel> viewAllProduct ();
	ProductModel selectProduk (String id);
	void updateProduk (ProductModel produk);
	void addProduk (ProductModel produk);
}
