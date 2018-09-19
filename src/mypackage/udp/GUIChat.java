package mypackage.udp;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIChat extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel south;
	private JTextField tf;
	private JButton send;
	private JButton log;
	private JButton clear;
	private JButton shake;
	private JPanel center;
	private JTextArea receiveArea;
	private JTextArea sendArea;
	private DatagramSocket dgs;
	private DatagramPacket dgp;
	private BufferedWriter bfw;
	

	public GUIChat() {
		try {
			new RecvMessage().start();
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		southPanel();
		centerPanel();
		event();
		this.setVisible(true);
	}
	private void init() throws IOException {
		this.setLayout(new BorderLayout());
		this.setLocation(400, 100);
		this.setSize(500, 700);
		dgs = new DatagramSocket();
		bfw = new BufferedWriter(new FileWriter("src/mypackage/socket/messageLog", true));
	}
	private void southPanel() {
		south = new JPanel();
		tf = new JTextField(15);
		tf.setText("127.0.0.1");
		send = new JButton("发送");
		log = new JButton("记录");
		clear = new JButton("清屏");
		shake = new JButton("震动");
		south.add(tf);
		south.add(send);
		south.add(log);
		south.add(clear);
		south.add(shake);
		this.getContentPane().add(south, BorderLayout.SOUTH);
	}
	private void centerPanel() {
		center = new JPanel();
		receiveArea = new JTextArea();
		sendArea = new JTextArea("send",5,0);
		receiveArea.setEditable(false);
		center.setLayout(new BorderLayout());
		receiveArea.setFont(new Font("nothing", Font.PLAIN, 17));
		sendArea.setFont(new Font("nothing", Font.PLAIN, 17));
		center.add(receiveArea, BorderLayout.CENTER);
		center.add(sendArea, BorderLayout.SOUTH);
		this.getContentPane().add(center, BorderLayout.CENTER);
	}
	
	private void event() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dgs.close();
				try {
					bfw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		send.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					sendMessage();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		log.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					msglog();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				receiveArea.setText("");
			}
		});
		shake.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					send(new byte[] {-1}, tf.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		sendArea.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER && e.isControlDown())
				try {
					sendMessage();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}
		});
	}
	
	private void send(byte[] arr, String ip) throws IOException {
		dgp = new DatagramPacket(
				arr, arr.length, InetAddress.getByName(ip), 21567);
		dgs.send(dgp);
	}
	
	private void sendMessage() throws IOException {
		String msg = sendArea.getText();
		String ip = tf.getText();
		ip = ip.trim().length() == 0 ? "255.255.255.255" : ip ;
		send(msg.getBytes(), ip);
		sendArea.setText("");
		String msgView = getCurrentTime() + " I say to " + 
					(ip.equals("255.255.255.255") ? " everyone" : ip ) +  "\n" + msg + "\n\n"  ;
		bfw.write(msgView);
		receiveArea.append(msgView);
	}
	
	private String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	
	private class RecvMessage extends Thread{
		private DatagramSocket recvSocket;
		@Override
		public void run() {
			try {
				recvSocket = new DatagramSocket(21567);
			} catch (SocketException e) {
				e.printStackTrace();
			}
			DatagramPacket recvPackage = new DatagramPacket(new byte[8192], 8192);				
			while (true) {
				try {
					recvSocket.receive(recvPackage);
				} catch (IOException e) {
					e.printStackTrace();
				}
				byte[] arr = recvPackage.getData();
				int len = recvPackage.getLength();
				if(arr[0] == -1 && len == 1){
					shakeWindow();
					continue;
				}
				String msg = new String(arr, 0 ,len);
				String ip = recvPackage.getAddress().getHostAddress(); 
				String msgView = getCurrentTime() + " "+ ip + " say to me " + "\n" + msg + "\n\n";
				try {
					bfw.write(msgView);
				} catch (IOException e) {
					e.printStackTrace();
				}
				receiveArea.append(msgView);
			}	
		}
	}
	private void msglog() throws IOException {
		bfw.flush();
		FileInputStream fis = new FileInputStream("src/mypackage/socket/messageLog");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] arr = new byte[8192];
		int len;
		while((len=fis.read(arr)) != -1)
			baos.write(arr, 0 ,len);
		String msg = baos.toString();
		receiveArea.setText(msg);
		fis.close();
	}
	private void shakeWindow() {
		int x = this.getX();
		int y = this.getY();
		for (int i=0; i<20; i++) {
			this.setLocation(x-10, y-10);
			this.setLocation(x-10, y+10);
			this.setLocation(x+10, y+10);
			this.setLocation(x+10, y-10);
			this.setLocation(x, y);
		}	
	}
	public static void main(String[] args) {
		new GUIChat();
	}

}
