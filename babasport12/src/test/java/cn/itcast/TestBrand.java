package cn.itcast;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.common.junit.SpringJunitTest;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.query.product.BrandQuery;
import cn.itcast.core.service.product.BrandService;

/**
 * 测试
 * @author lx
 *
 */

public class TestBrand extends SpringJunitTest{

	@Autowired
	private BrandService brandService;
	@Test
	public void testGet() throws Exception {
		BrandQuery  brandQuery = new BrandQuery();
		
		//brandQuery.setFields("id");
		//brandQuery.setNameLike(true);
		//brandQuery.setName("金");
		brandQuery.orderbyId(false);
		
		brandQuery.setPageNo(2);
		brandQuery.setPageSize(2);
		
		List<Brand> brands = brandService.getBrandList(brandQuery);
		
		for (Brand b : brands) {
			System.out.println(b);
		}
	}
}
