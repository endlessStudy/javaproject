package cn.itcast.jk.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.SysCodeDao;
import cn.itcast.jk.domain.SysCode;
import cn.itcast.jk.service.SysCodeService;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月13日
 */
@Service
public class SysCodeServiceImpl implements SysCodeService {
	@Resource
	SysCodeDao sysCodeDao;

	public List<SysCode> find(Map paraMap) {
		return sysCodeDao.find(paraMap);
	}

}
