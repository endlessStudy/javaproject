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
 * <p>
 * |****************************** *_* ******************************|
 * |   __                                                      __    |
 * | _/  |_  ____ _____ _______    ______ _____ _____ ________/  |_  |
 * | \   __\/ __ \\__  \\_  __ \  /  ___//     \\__  \\_  __ \   __\ |
 * |  |  | \  ___/ / __ \|  | \/  \___ \|  Y Y  \/ __ \|  | \/|  |   |
 * |  |__|  \___  >____  /__|    /____  >__|_|  (____  /__|   |__|   |
 * |            \/     \/             \/      \/     \/              |
 * |                                                                 |
 * |****************************** *_* ******************************|
 * </p>
 * 由于建立zookeeper会话的过程是异步的,当构造玩zk对象后,线程会继续执行后续代码,单此时会话有可能还未创建完毕,一次使用
 * countDownLatch工具,当创建zk对象完毕后,立马调用latch.await()方法(关闭阀门),使线程处于阻塞状态,等待syncConnected事件到来时,
 * 在执行latch.countDown()方法(打开阀门),,此时会话已创建完毕,加下来当前线程就可以继续执行代码了.
 *
 * zookeeper官网提供两套api,同步和异步
 * @author tear-smart
 * @date 2019/2/18
 */
public class ZkGroupDemo implements Watcher {
    public static final int SESSION_TIMEOUT = 5000;
    private CountDownLatch countDownLatch = new CountDownLatch(1);
    private ZooKeeper zooKeeper;

    public void close() throws InterruptedException {
        zooKeeper.close();
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            countDownLatch.countDown();
        }
    }

    public void createZkConn() throws IOException, InterruptedException {
        zooKeeper = new ZooKeeper("120.79.4.101", SESSION_TIMEOUT, this);
        countDownLatch.await();
    }

    public static void main(String[] args) throws Exception {
        ZkGroupDemo zkGroupDemo = new ZkGroupDemo();
        zkGroupDemo.createZkConn();
        zkGroupDemo.close();
    }


}
