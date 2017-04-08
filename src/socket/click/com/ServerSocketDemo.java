package socket.click.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo  extends Thread{
     //创建一个ServerSocket
	ServerSocket server;
	//计数
	int num=0;
	  
	  public ServerSocketDemo() {
	    //创建ServerSocket,用于监听25555端口是否有客户端Socket
		  try {
			server=new ServerSocket(25555);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  //启动当前线程，即执行run()方法\
		  this.start();
		  System.out.println("服务器启动....");
	 }
     @Override
    public void run() {
          while(this.isAlive()){
        	  //接收客户端的Socket
        	  try {
				Socket socket=server.accept();
				//将Socket对应的输入流包装成BufferedReader
				BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//读取客户端发送的信息并显示
				String line=br.readLine();
				System.out.println(line);
				//将Socket对应的输出流包装成PrintStream
				PrintStream ps=new PrintStream(socket.getOutputStream());
				//往客户端发送信息
				ps.println("您是第"+(++num)+"访问服务器的用户!");
				ps.flush();
				//关闭
				br.close();
				ps.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	  
          }
    }
     public static void main(String[] args) {
		 new  ServerSocketDemo();
	}
}
