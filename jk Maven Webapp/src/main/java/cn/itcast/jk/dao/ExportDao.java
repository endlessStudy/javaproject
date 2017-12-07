package cn.itcast.jk.dao;

import java.util.Map;

import cn.itcast.jk.domain.Export;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
public interface ExportDao extends BaseDao<Export> {
	public void updateState(Map map);			//修改状态
}
