package socket.click.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo  extends Thread{
     //����һ��ServerSocket
	ServerSocket server;
	//����
	int num=0;
	  
	  public ServerSocketDemo() {
	    //����ServerSocket,���ڼ���25555�˿��Ƿ��пͻ���Socket
		  try {
			server=new ServerSocket(25555);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  //������ǰ�̣߳���ִ��run()����\
		  this.start();
		  System.out.println("����������....");
	 }
     @Override
    public void run() {
          while(this.isAlive()){
        	  //���տͻ��˵�Socket
        	  try {
				Socket socket=server.accept();
				//��Socket��Ӧ����������װ��BufferedReader
				BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//��ȡ�ͻ��˷��͵���Ϣ����ʾ
				String line=br.readLine();
				System.out.println(line);
				//��Socket��Ӧ���������װ��PrintStream
				PrintStream ps=new PrintStream(socket.getOutputStream());
				//���ͻ��˷�����Ϣ
				ps.println("���ǵ�"+(++num)+"���ʷ��������û�!");
				ps.flush();
				//�ر�
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
