package com.lxy.invoke.callback;

/**
 * Created by liuyl on 2018/1/16.
 */
public class Wang implements CallBack {
    private Li li;
    public Wang(Li li){
        this.li = li;
    }
    public  void askQuestion(final String question){
        li.firstAsk();
        new Thread(new Runnable() {
            @Override
            public void run() {
                li.executeMessage(Wang.this,question);
            }
        }).start();
        play();
    }
    public void play(){
        System.out.println("我要逛街去了");
    }
    @Override
    public void solve(String result) {
        System.out.println("小李告诉小王的答案是--->" + result);
    }
}
