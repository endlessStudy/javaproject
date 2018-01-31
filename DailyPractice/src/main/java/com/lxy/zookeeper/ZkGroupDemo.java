package com.lxy.zookeeper;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

/**
 * Created by liuyl on 2018/1/26.
 */
public class ZkGroupDemo implements Watcher{
    public static final int SESSION_TIMEOUT = 5000;
    private CountDownLatch countDownLatch = new CountDownLatch(1);
    private ZooKeeper zooKeeper;
    public void close() throws InterruptedException {
        zooKeeper.close();
    }
    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected){
            countDownLatch.countDown();
        }
    }
    public void createZkConn() throws IOException, InterruptedException {
        zooKeeper = new ZooKeeper("120.79.4.101",SESSION_TIMEOUT,this);
        countDownLatch.await();
    }

    public static void main(String[] args) throws Exception {
        ZkGroupDemo zkGroupDemo = new ZkGroupDemo();
        zkGroupDemo.createZkConn();
        zkGroupDemo.close();
    }


}
