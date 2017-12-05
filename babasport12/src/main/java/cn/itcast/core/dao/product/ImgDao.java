package cn.itcast.core.dao.product;

import java.util.List;

import cn.itcast.core.bean.product.Img;
import cn.itcast.core.query.product.ImgQuery;

public interface ImgDao {

	/**
	 * 添加
	 * @param img
	 */
	public Integer addImg(Img img);

	/**
	 * 根据主键查找
	 * @param imgQuery
	 */
	public Img getImgByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param imgQuery
	 */
	public List<Img> getImgsByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * @param imgQuery
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * @param imgQuery
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * @param imgQuery
	 */
	public Integer updateImgByKey(Img img);

	/**
	 * 分页查询
	 * @param imgQuery
	 */
	public List<Img> getImgListWithPage(ImgQuery imgQuery);

	/**
	 * 集合查询
	 * @param imgQuery
	 */
	public List<Img> getImgList(ImgQuery imgQuery);
	
	/**
	 * 总条数
	 * @param imgQuery
	 */
	public int getImgListCount(ImgQuery imgQuery);
}
