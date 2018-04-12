package com.qsx.crm.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证码
 * @author Mryang
 *
 */
public class CaptchaUtil {
	
	/**
	 * 生成验证码
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void generateCaptcha(HttpServletRequest request, HttpServletResponse response)
	throws ServletException,IOException{
		response.setHeader("Pragma", "nocache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		
		BufferedImage bim = new BufferedImage(70, 20, BufferedImage.TYPE_INT_RGB);
		Graphics2D gc = bim.createGraphics();
		//设置图片填充颜色
		gc.setColor(Color.yellow);
		gc.fillRect(0, 0, 70, 20);
		//设置边框颜色
		gc.setColor(Color.pink);
		gc.drawRect(0, 0, 69, 19);
		//产生4位随机数
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		//设置干扰线颜色
		gc.setColor(Color.cyan);
		for(int j = 0;j< 30; j++){
			int x = random.nextInt(70);
			int y = random.nextInt(20);
			int x1 = random.nextInt(6);
			int y1 = random.nextInt(6);
			gc.drawLine(x, y, x+x1, y+y1);
		}
		
		for(int i = 0; i < 4; i++){
			int m = random.nextInt(9);
			//将生成的数字写入到图片中去，int转换成stirng
			String str = String.valueOf(m);
			//设置字体颜色
			gc.setColor(Color.RED);
			gc.drawString(str, i * 10+20,15);
			sb.append(m);
		}
		//将Stringbuffer转换成String
		String sb1 = String.valueOf(sb);
		//将生成的验证码的值放入到session中去
		
		System.out.println("生成的验证码:"+sb1);
		request.getSession().setAttribute("login-captcha", sb1);
		//将图片以流的形式输出
		ServletOutputStream sos = response.getOutputStream();
		ImageIO.write(bim, "jpg", sos);
		sos.close();
	}
}
