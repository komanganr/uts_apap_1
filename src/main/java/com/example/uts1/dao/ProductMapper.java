package com.example.uts1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.uts1.model.ProductModel;

@Mapper
public interface ProductMapper {
	@Select ("SELECT * FROM product")
	List<ProductModel> viewAllProduct();
	
	
	@Select("SELECT * FROM product WHERE id = #{id}")
	@Results(value = {
			@Result(property = "id", column = "id"),
			@Result(property = "nama", column = "nama"),
			@Result(property = "deskripsi", column = "deskripsi"),
			@Result(property = "kategori", column = "kategori"),
			@Result(property = "pabrikan", column = "pabrikan"),
			@Result(property = "berat", column = "berat"),
			@Result(property = "harga", column = "harga"),
			@Result(property = "tahun_produksi", column = "tahun_produksi"),
			@Result(property = "jumlah_stok", column = "jumlah_stok"),
			@Result(property = "kondisi", column = "kondisi") })
	ProductModel selectProduk(@Param("id") int id);
	
	
	@Insert("INSERT INTO product (nama, deskripsi, kategori, pabrikan, berat, harga, tahun_produksi, jumlah_stok, kondisi) "
			+ "VALUES (#{nama}, #{deskripsi}, #{kategori}, #{pabrikan}, #{berat}, #{harga}, #{tahun_produksi}, #{jumlah_stok}, #{kondisi})")
	void addProduk (ProductModel produk);
	
/*	@Update("UPDATE product "
			+ "SET nama=#{nama}, deskripsi = #{deskripsi}, kategori = #{kategori}, pabrikan= #{pabrikan}, berat = #{berat}, harga=#{harga}, tahun_produksi = #{tahun_produksi}, jumlah_stok = #{jumlah_stok}, kondisi = #{kondisi} "
			+ "WHERE id = #{id}")
    void updateProduk(ProductModel produk);*/
	
/*	@Update("UPDATE penduduk "
			+ "SET nama=#{nama}, deskripsi = #{deskripsi}, kategori= #{kategori}, pabrikan = #{pabrikan}, berat = #{berat}, harga = #{harga}, tahun_produksi = #{tahun_produksi}, jumlah_stok= #{jumlah_stok}, kondisi = #{kondisi} "
			+ "WHERE id = #{id}")
    void updateProduk(ProductModel produk);*/
	
	@Update("UPDATE product SET nama=#{nama}, deskripsi = #{deskripsi}, kategori= #{kategori}, pabrikan = #{pabrikan}, berat = #{berat}, harga = #{harga}, tahun_produksi = #{tahun_produksi}, jumlah_stok= #{jumlah_stok}, kondisi = #{kondisi} WHERE id = #{id}")
	void updateProduk(ProductModel produk);
}
