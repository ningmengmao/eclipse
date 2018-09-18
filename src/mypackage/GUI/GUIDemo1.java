package mypackage.GUI;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class GUIDemo1 {

	/**
	 * 	用windowAdapter   替代WindowListener
	 */
	public static void main(String[] args) {
		Frame f = new Frame("我的窗口");			
		f.setSize(400, 600);					// 窗体大小
		f.setLocation(500, 50);					// 窗体位置
		f.setIconImage(Toolkit.getDefaultToolkit().createImage("src/mypackage/GUI/test.png"));
		JButton b1 = new JButton("按钮一");
		JButton b2 = new JButton("按键二");
		f.add(b1);								// 添加按钮
		f.add(b2);
		b1.setFocusable(true);  			//设置按钮焦点
		f.setLayout(new FlowLayout());			// 设置布局管理器
		f.addWindowListener(new WindowAdapter() {		// 窗口监听
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {	//鼠标释放
				System.exit(0);
			}
		});
		b1.addKeyListener(new KeyAdapter() {		//键盘事件
			@Override	
			public void keyReleased(KeyEvent e) {	// 释放
				if( e.getKeyCode() == KeyEvent.VK_ENTER)	// 按键为space才生效
					System.exit(0);
//				else if( e.getKeyCode() == KeyEvent.VK_TAB) {		不行
//					b1.setFocusable(false);
//					b2.setFocusable(true);
//				}
			}
		});
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		//鼠标和键盘(默认space)都能触发的事件
				System.exit(0);
			}
		});
		f.setVisible(true);						// 设置窗体可见
	}

}

