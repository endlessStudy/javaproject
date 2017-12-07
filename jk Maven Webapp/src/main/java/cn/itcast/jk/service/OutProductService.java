package cn.itcast.jk.service;

import java.util.List;

import cn.itcast.jk.vo.OutProductVO;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
public interface OutProductService {
	public List<OutProductVO> find(String inputDate);		//带条件查询，条件可以为null，既没有条件；返回list对象集合
}
