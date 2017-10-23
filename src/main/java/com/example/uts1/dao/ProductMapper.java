package com.example.uts1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.uts1.model.ProductModel;

@Mapper
public interface ProductMapper {
	@Select ("SELECT * FROM product")
	List<ProductModel> viewAllProduct();
}
