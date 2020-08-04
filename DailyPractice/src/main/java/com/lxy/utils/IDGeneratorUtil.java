package com.lxy.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.TimeoutUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class IDGeneratorUtil {
	private static Jedis jedis;


	public static void main(String[] args) {
		RedisUtil.initRedisPool();
		JedisPool jedisPool = RedisPool.INSTANCE.getJedisPool();
		jedis = jedisPool.getResource();
		String ft = getRedisNo("FT", 5, true, false);
		System.out.println(ft);
	}

	/**
	 * 通过Redis获取自增序号
	 * @param pre 前缀
	 * @param length 序号长度
	 * @param increment 是否自增
	 * @param isDate 是否只获取年月
	 * @return 前缀+日期+序列号
	 */
	public static String getRedisNo(String pre, int length, boolean increment, boolean isDate) {
		return getRedisNo(pre, "", length, increment, isDate);
	}

	/**
	 * 通过Redis获取自增序号
	 * @param pre 前缀
	 * @param middle 中间数
	 * @param length 序号长度
	 * @param increment 是否自增
	 * @param isDate 是否只获取年月
	 * @return 前缀+中间数+日期+序列号
	 */
	public static String getRedisNo(String pre, String middle, int length, boolean increment, boolean isDate) {
		// 日期
		String date;
		if (isDate) {
			date = LocalDate.now().getYear() + "" + LocalDate.now().getMonthValue();
		} else {
			date = LocalDate.now().format(DateTimeFormatter.ISO_DATE).replace("-", "");
		}
		// 编号
		String no;
		if (increment) {
			// 自增获取
			Long temp = jedis.incrBy(pre + date, 1);
			if (temp == 1) {
				// 过期时间

				jedis.expire(pre + date, (int) TimeoutUtils.toSeconds(isDate ? 30 : 1, TimeUnit.DAYS));
			}
			no = temp.toString();
		} else {
			// 非自增获取
			no = jedis.get(pre + date);
			if (StringUtils.isEmpty(no)) {
				no = jedis.incrBy(pre + date, 1).toString();
				jedis.expire(pre + date, (int) TimeoutUtils.toSeconds(isDate ? 30 : 1, TimeUnit.DAYS));
			}
		}

		if (no.length() >= length) {
			return pre + middle + date + no;
		} else {
			// 补齐
			StringBuilder temp = new StringBuilder();
			for (int i = 0; i < length - no.length(); i++) {
				temp.append("0");
			}
			return pre + middle + date + temp.toString() + no;
		}
	}
}