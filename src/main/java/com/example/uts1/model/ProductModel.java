package com.example.uts1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
	private int id;
	private String nama;
	private String deskripsi;
	private String kategori;
	private String pabrikan;
	private double berat;
	private int harga;
	private int tahun_produksi;
	private int jumlah_stok;
	private String kondisi;
/*	private Integer id;
	private String nama;
	private String deskripsi;
	private String kategori;
	private String pabrikan;
	private double berat;
	private int harga;
	private int tahunProduksi;
	private int jumlahStok;
	private String kondisi;*/
}
