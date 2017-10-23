package com.example.uts1.service;

import java.util.List;

import com.example.uts1.model.ProductModel;

public interface ProductService {
	List<ProductModel> viewAllProduct ();
	ProductModel selectProduk (int id);
	void addProduk (ProductModel produk);
	void updateProduk (ProductModel produk);
}
