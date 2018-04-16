import com.lxy.utils.PropUtils;

/**
 * Created by liuyl on 2018/3/21.
 */
public class PropTest {
    public static void main(String[] args) {
        String string = PropUtils.getProperties("prop/redis.properties").getProperty("redis.ip");
        System.out.println(string);
    }
}
