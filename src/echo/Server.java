package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		
		//서버 소켓 생성
		ServerSocket serverSocket=new ServerSocket();
		
		//바인딩
		serverSocket.bind(new InetSocketAddress("192.168.0.57", 10001));
		
		//서버 시작
		System.out.println("<서버 시작>");
		System.out.println("===============================================");
		
		while (true) {
			System.out.println("[연결을 기다리고 있습니다.]");
			
			//클라이언트가 접속하면 실행
			Socket socket=serverSocket.accept();	//소켓 만드는 역할
			
			//출장	thread.start();
			Thread thread=new ServerThread(socket);
			thread.start();
		}
		/*
		System.out.println("============================================");
		System.out.println("<서버 종료>");
		
		//닫기
		serverSocket.close();
		socket.close();
*/
	}

}
