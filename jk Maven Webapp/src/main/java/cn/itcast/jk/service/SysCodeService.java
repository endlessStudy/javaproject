package cn.itcast.jk.service;

import java.util.List;
import java.util.Map;

import cn.itcast.jk.domain.SysCode;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
public interface SysCodeService {
	public List<SysCode> find(Map paraMap);			//带条件查询，条件可以为null，既没有条件；返回list对象集合
}
