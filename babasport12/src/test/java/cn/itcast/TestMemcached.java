package cn.itcast;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.common.junit.SpringJunitTest;
import cn.itcast.common.web.aop.MemCachedUtil;
import cn.itcast.core.bean.user.Buyer;

import com.danga.MemCached.MemCachedClient;

/**
 * 测试
 * @author lx
 *
 */

public class TestMemcached extends SpringJunitTest{

	@Autowired
	private MemCachedClient memCachedClient;
	@Test
	public void testAdd() throws Exception {
		Buyer buyer = new Buyer();
		buyer.setUsername("范冰冰");
		
		
		//memCachedClient.set("fbb2",buyer);
		
		Map<String, Object> keySet = MemCachedUtil.getKeySet(memCachedClient);
		
		
		Set<Entry<String, Object>> entrySet = keySet.entrySet();
		for(Entry<String, Object> entry : entrySet){
			System.out.println(entry.getKey());
		}
		
		
/*		Object object = memCachedClient.get("fbb");
		
		System.out.println(object);*/
	}
}
