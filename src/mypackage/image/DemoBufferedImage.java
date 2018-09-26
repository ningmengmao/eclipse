package mypackage.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DemoBufferedImage {
	private static Graphics2D g2d ;
	private static String str;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		/*
		 * Image, ImageIO, BufferedImage, Icon, ImageIcon
		 */
		
		BufferedImage bi = new BufferedImage(100, 50, BufferedImage.TYPE_INT_BGR);
		g2d = (Graphics2D) bi.getGraphics();
		
		str="abcd";
		char[] arr = str.toCharArray();
		//设置白色背景
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, 100, 50);
		
		g2d.setFont(new Font("宋体", Font.PLAIN, 30));
		g2d.setColor(Color.BLACK);
		for(int i=0; i<4; i++)
			g2d.drawString(String.valueOf(arr[i]), 25*i, 35);
		ImageIO.write(bi, "JPEG", new FileOutputStream("src/mypackage/image/1.jpg"));		
	}


}
