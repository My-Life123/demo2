package socket.click.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketDemo {
      public static void main(String[] args) {
		try {
			//创建连接到本机、端口为25555的socket对象
			Socket socket=new Socket("127.0.0.1",25555);
			//将Socket对应的输出流包装成PrintStream
			PrintStream ps=new PrintStream(socket.getOutputStream());
			//往服务器发送消息
			ps.println("我是李四");
			ps.flush();
			//将Socket对应的输入流包装成BufferedReader
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//读取服务器返回的信息显示
			String line=br.readLine();
			System.out.println("来自服务器的数据:"+line);
			//关闭
			br.close();
			ps.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
}
