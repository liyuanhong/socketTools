package com.lyh.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class YNServerSocket extends SocketBase {
	private int port = 5000;         //端口号
	private ServerSocket server = null;
	private Socket socket = null;
	private InputStream inputStream = null;
	/*
	 * 定义构造函数
	 */
	public YNServerSocket(){
		
	}
	
	public YNServerSocket(int port) {
		this.port = port;
	}
	
	
	/*
	 * 创建一个服务端socket
	 */
	public Socket createServerSocket(){
		try {
			server = new ServerSocket(port);
			socket = server.accept();
			InputStream inputStream = socket.getInputStream();
			byte[] data = new byte[4096];
			int len;
			StringBuilder sb = new StringBuilder();
			while((len = inputStream.read(data)) != -1){
				sb.append(new String(data, 0, len, "UTF-8"));
			}
			System.out.println("get message from client: " + sb);
			System.out.println("server获取客户端端口号:" + socket.getPort());
			System.out.println("server获取本机端口号:" + socket.getLocalPort());
			inputStream.close();
			socket.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return socket;
	}
	
	
	/*
	 * 关闭socket
	 */
	public void closeSocket(){
		try {
			if(server != null){ server.close(); }
			if(socket != null){ socket.close(); }
			if(inputStream != null){ inputStream.close(); }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 设置端口号
	 */
	public void setPort(int port){
		this.port = port;
	}
	
	/*
	 * 获取端口号
	 */
	public int getPort(){
		return port;
	}
}
