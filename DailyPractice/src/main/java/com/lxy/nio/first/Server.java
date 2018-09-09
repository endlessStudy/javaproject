package com.lxy.nio.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * Created by liuyl on 2018/4/4.
 */
public class Server {
    final static int PROT = 7788;
    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        server = new ServerSocket(PROT);
        System.out.println(" server start .. ");
        //进行阻塞
        Socket socket = server.accept();
        //新建一个线程执行客户端的任务
        new Thread(new ServerHandler(socket)).start();
    }
}
class ServerHandler implements Runnable{

    private Socket socket ;

    public ServerHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(), true);
            String body = null;
            while(true){
                body = in.readLine();
                if(body == null) break;
                System.out.println("Server :" + body);
                out.println("服务器端回送响的应数据.");

                /*out.write("服务器端回送响的应数据.");
                out.close();*/
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
