package com.lxy.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

public class demo {
	// 会话超时时间，设置为与系统默认时间一致
	private static final int SESSION_TIMEOUT = 30000;
	// 创建 ZooKeeper 实例
	ZooKeeper zk;
	// 创建 Watcher 实例
	Watcher watcher = new Watcher() {
		@Override
		public void process(org.apache.zookeeper.WatchedEvent event) {
			System.out.println("event=" + event.toString());
		}
	};

	// 初始化 ZooKeeper 实例
	private void createZKInstance() throws IOException {
		zk = new ZooKeeper("120.79.4.109:80", demo.SESSION_TIMEOUT, this.watcher);
	}

	private void ZKOperations() throws IOException, InterruptedException, KeeperException {
		System.out.println("\n 创建 ZooKeeper 节点 (znode ： zoo2, 数据： myData2 ，权限： OPEN_ACL_UNSAFE ，节点类型： Persistent");
		//persistent 永久的 ephemeral 短暂的--临时的
		zk.create("/zoo2", "myData2".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		System.out.println("\n 查看是否创建成功： ");
		System.out.println(new String(zk.getData("/zoo2", false, null)));
		System.out.println("\n 修改节点数据 ");
		zk.setData("/zoo2", "shenlan211314".getBytes(), -1);
		System.out.println("\n 查看是否修改成功： ");
		System.out.println("2222" + new String(zk.getData("/zoo2", false, null)));
		System.out.println("\n 删除节点 ");
		zk.delete("/zoo2", -1);
		System.out.println("\n 查看节点是否被删除： ");
		System.out.println(" 节点状态： [" + zk.exists("/zoo2", false) + "]");
	}

	private void ZKClose() throws InterruptedException {
		zk.close();
	}

	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		demo dm = new demo();
		dm.createZKInstance();
		dm.ZKOperations();
		dm.ZKClose();
	}

	public void getChilds() {
		try {
			List<String> children = zk.getChildren("/dubbo", watcher);
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}