import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liuyl on 2018/2/27.
 */
public class ExceptionDemo {

	public static void main(String[] args) {
		String dataNames;

		Map<String, String> map = new HashMap<String, String>();
		ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
		Map map1 = new Hashtable();
		concurrentHashMap.put("key", "value");
		map.keySet();
		for (Map.Entry me : map.entrySet()) {
		}

	}
}
