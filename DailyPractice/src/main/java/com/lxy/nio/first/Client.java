package com.lxy.nio.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by liuyl on 2018/4/4.
 */
public class Client {
	private static final String ADDRESS = "127.0.0.1";
	private static final int PORT = 7788;

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader bufferedReader = null;
		PrintWriter printWriter = null;
		try {
			socket = new Socket(ADDRESS, PORT);
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			printWriter = new PrintWriter(socket.getOutputStream(), true);

			//向服务器端发送数据
			printWriter.println("接收到客户端的请求数据...");
			printWriter.println("接收到客户端的请求数据1111...");
			String response = bufferedReader.readLine();
			System.out.println("Client: " + response);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
