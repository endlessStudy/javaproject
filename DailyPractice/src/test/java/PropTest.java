import java.util.Arrays;

/**
 * Created by liuyl on 2018/3/21.
 */
public class PropTest {
	public static void main(String[] args) {
		// String string = PropUtils.getProperties("prop/redis.properties").getProperty("redis.ip");
		// System.out.println(string);
		int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.arraycopy(arr, 3, arr, 2, 5);
		System.out.println(Arrays.toString(arr));
	}
}
