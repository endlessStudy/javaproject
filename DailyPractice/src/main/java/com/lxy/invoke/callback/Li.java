package com.lxy.invoke.callback;

/**
 * Created by liuyl on 2018/1/16.
 */
public class Li {
	public void executeMessage(CallBack callBack, String question) {
		System.out.println("小王问的问题--->" + question);
		for (int i = 0; i < 10000; i++) {

		}
		String result = "答案是2";
		callBack.solve(result);
	}

	public void firstAsk() {
		System.out.println("小李：我也不知道，我想一下告诉你！");
	}

}
