package com.lxy.thread.condition;

import com.lxy.thread.condition.Task;

public class AddThread implements Runnable {

    private Task task;

    public AddThread(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.add();
    }

}