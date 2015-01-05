import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ScanUsePort extends Thread {
	private int port;
	private static String serverIP;

	public ScanUsePort(int p) {
		this.port = p;
	}

	public void run() {
		try {
			Socket s = new Socket(serverIP, port);
			System.out.println(port);
			s.close();
		} catch (IOException e) {
		}
	}

	public static void main(String[] args) {
		//192.168.1.101
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入主机地址：");
		serverIP = sc.nextLine();
		System.out.println("主机" + serverIP + "使用中在TCP端口为：");
		for (int i = 0; i < 1024; i++) {
			ScanUsePort scanUsePort = new ScanUsePort(i);
			scanUsePort.start();
		}
	}
	
}