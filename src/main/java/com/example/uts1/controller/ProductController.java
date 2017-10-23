package com.example.uts1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	@RequestMapping("/product/view/{id}")
	public String viewPath(Model model, @PathVariable(value = "id") int id) {
		ProductModel produk = productDAO.selectProduk(id);
		if (produk != null) {
			model.addAttribute("produk", produk);
			return "view-product";
		} else {
			model.addAttribute("id", id);
			return "not-found";
		}
	}
	
	@RequestMapping("/product/add")
	public String add() {
		return "add-product";
	}

	@RequestMapping("/product/add/submit")
	public String addSubmit(Model model,
			@RequestParam(value = "nama", required = false) String nama,
			@RequestParam(value = "deskripsi", required = false) String deskripsi,
			@RequestParam(value = "kategori", required = false) String kategori,
			@RequestParam(value = "pabrikan", required = false) String pabrikan,
			@RequestParam(value = "berat", required = false) double berat,
			@RequestParam(value = "harga", required = false) int harga,
			@RequestParam(value = "tahun_produksi", required = false) int tahun_produksi,
			@RequestParam(value = "jumlah_stok", required = false) int jumlah_stok,
			@RequestParam(value = "kondisi", required = false) String kondisi) {
		ProductModel produk = new ProductModel(0, nama, deskripsi, kategori, pabrikan, berat, harga, tahun_produksi, jumlah_stok, kondisi);
		productDAO.addProduk (produk);
		model.addAttribute("title","Add Success");
		return "viewall";
	}
	
	
/*	@RequestMapping("/product/update/{id}")
	public String update(Model model, @PathVariable(value = "id") int id) {
		ProductModel produk = productDAO.selectProduk(id);
		if (produk != null) {
			model.addAttribute("produk", produk);
			return "update-product";
		} else {
			model.addAttribute("id", id);
			return "not-found";
		}
	}*/

/*	@RequestMapping(value = "/product/update/submit/{id}", method = RequestMethod.POST)
	public String updateProductSubmit (Model model, @PathVariable(value = "id") int id, ProductModel produk) {
		ProductModel produkAwal = productDAO.selectProduk(id);

		produk.setId(produkAwal.getId());
		model.addAttribute("id", produk.getId());
		productDAO.updateProduk(produk);
		ProductModel produk = new ProductModel(0, nama, deskripsi, kategori, pabrikan, berat, harga, tahun_produksi, jumlah_stok, kondisi);
		return "/";
	}*/
	
/*	@RequestMapping("/product/update/{id}")
	public String updatePenduduk (Model model, @PathVariable(value = "id") int id) {
		ProductModel produk = productDAO.selectProduk(id);
		if (produk != null) {
			model.addAttribute("produk", produk);
			return "update-product";
		} else {
			model.addAttribute("errormessage", "Penduduk dengan NIK " + id
					+ " tidak ditemukan, mohon cek kembali Nomor Induk Kependudukan Anda.");
			return "layout/error";
		}
	}
	
	@RequestMapping(value = "/product/update/submit/{id}", method = RequestMethod.POST)
	public String updatePendudukSubmit (Model model, @PathVariable(value = "id") int id, ProductModel produk) {
		ProductModel produkAwal = productDAO.selectProduk(id);
		
		produk.setId(produkAwal.getId());
//		model.addAttribute("nik", penduduk.getNik());
		productDAO.updateProduk(produk);
		
		return "index";
	}*/
	
	@RequestMapping("/product/update/{id}")
	public String update(Model model, @PathVariable(value = "id") int id) {
		ProductModel produk = productDAO.selectProduk(id);
		if (produk != null) {
			model.addAttribute("produk", produk);
			model.addAttribute("title","Update Student");
			return "update-product";
		} else {
			model.addAttribute("id", id);
			return "not-found";
		}
	}

	@RequestMapping(value = "/product/update/submit/{id}", method = RequestMethod.POST)
	public String updateSubmit(ProductModel produk, Model model)
	{
    	productDAO.updateProduk(produk);
    	model.addAttribute("title","Update Student Success");
        return "viewall";
	}
	
}
