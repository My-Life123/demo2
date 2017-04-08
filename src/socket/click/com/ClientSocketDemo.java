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
			//�������ӵ��������˿�Ϊ25555��socket����
			Socket socket=new Socket("127.0.0.1",25555);
			//��Socket��Ӧ���������װ��PrintStream
			PrintStream ps=new PrintStream(socket.getOutputStream());
			//��������������Ϣ
			ps.println("��������");
			ps.flush();
			//��Socket��Ӧ����������װ��BufferedReader
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//��ȡ���������ص���Ϣ��ʾ
			String line=br.readLine();
			System.out.println("���Է�����������:"+line);
			//�ر�
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
