package com.example.uts1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.uts1.model.ProductModel;
import com.example.uts1.service.ProductService;


@Controller
public class ProductController {
	@Autowired
	ProductService productDAO;
	
	@RequestMapping("/product/viewall")
	public String viewAllProduct(Model model) {
		List<ProductModel> produk = productDAO.viewAllProduct();
		model.addAttribute("produk", produk);
		return "viewall";
	}
}