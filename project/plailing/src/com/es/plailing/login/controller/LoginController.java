package com.es.plailing.login.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.plailing.entity.User;
import com.es.plailing.login.service.RegisterServiceImpl;

/**
 * 
 * @ClassName: LoginController
 * @Description: TODO(注册和登录)
 * @author 梁芳芳
 * @date 2018年12月6日
 *
 */
@Controller
public class LoginController {

	private int width = 140;// 定义图片的width
	private int height = 32;// 定义图片的height
	private int codeCount = 4;// 定义图片上显示验证码的个数
	private int xx = 25;
	private int fontHeight = 28;
	private int codeY = 26;
	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	@Resource
	private RegisterServiceImpl registerServiceImpl;

	/**
	 * 
	 * @Title: getCode @Description: TODO(获取验证码) @param @param request @param @param
	 *         response @param @throws IOException 参数 @return void 返回类型 @throws
	 */
	@RequestMapping("/captcha")
	public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 定义图像buffer
		BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics gd = buffImg.getGraphics();
		// 创建一个随机数生成器类
		Random random = new Random();
		// 将图像填充为白色
		gd.setColor(Color.WHITE);
		gd.fillRect(0, 0, width, height);
		// 创建字体，字体的大小应该根据图片的高度来定。
		Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
		// 设置字体。
		gd.setFont(font);
		// 画边框。
		gd.setColor(Color.BLACK);
		gd.drawRect(0, 0, width - 1, height - 1);
		// 随机产生40条干扰线，使图象中的认证码不易被其它程序探测到。
		gd.setColor(Color.BLACK);
		for (int i = 0; i < 40; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			gd.drawLine(x, y, x + xl, y + yl);
		}
		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;
		// 随机产生codeCount数字的验证码。
		for (int i = 0; i < codeCount; i++) {
			// 得到随机产生的验证码数字。
			String code = String.valueOf(codeSequence[random.nextInt(codeSequence.length - 1)]);
			// 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			// 用随机产生的颜色将验证码绘制到图像中。
			gd.setColor(new Color(red, green, blue));
			gd.drawString(code, (i + 1) * xx, codeY);
			// 将产生的四个随机数组合在一起。
			randomCode.append(code);
		}
		// 将四位数字的验证码保存到Session中。
		HttpSession session = request.getSession();
		session.setAttribute("code", randomCode.toString());
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		// 将图像输出到Servlet输出流中。
		ServletOutputStream sos = response.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();
	}

	/**
	 * 
	    * @Title: verify
	    * @Description: TODO(验证邮箱、密码、验证是否正确)
	    * @param @param email
	    * @param @param password
	    * @param @param captcha_v
	    * @param @param request
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("/verify")
	@ResponseBody
	public String verify(@RequestParam("email") String email, @RequestParam("password") String password, 
			@RequestParam("captcha_v") String captcha_v,HttpServletRequest request) {
		// 正则表达式邮箱格式
		String emailFormat = "^[a-zA-Z0-9_-]{5,20}+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
		Pattern pattern = Pattern.compile(emailFormat);
		Matcher matcher = pattern.matcher(email);
		boolean b = matcher.matches();

		// 正则表达式限制密码长度
		String passwordFormat = "^[0-9a-zA-Z]\\w{5,17}$";
		Pattern pattern1 = Pattern.compile(passwordFormat);
		Matcher matcher1 = pattern1.matcher(password);
		boolean b1 = matcher1.matches();

		// 获取验证码
		String sb = (String) request.getSession().getAttribute("code");

		String result = "";
		if (b && b1 && sb.equals(captcha_v)) {
			result = "1";
			return result;
		} else if (!b && b1 && sb.equals(captcha_v)) {
			result = "2";
			return result;
		} else if (b && !b1 && sb.equals(captcha_v)) {
			result = "3";
			return result;
		} else if(b && b1 && !sb.equals(captcha_v)){
			result = "4";
			return result;
		}else if(!b && !b1 && sb.equals(captcha_v)){
			result = "5";
			return result;
		}else if(!b && b1 && !sb.equals(captcha_v)){
			result = "6";
			return result;
		}else if(b && !b1 && !sb.equals(captcha_v)){
			result = "7";
			return result;
		}else {
			result = "8";
			return result;
		}
	}
	
	/**
	 * 
	    * @Title: verifyEmail
	    * @Description: TODO(验证邮箱输入格式)
	    * @param @param request
	    * @param @param email
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	
	@RequestMapping("/verifyEmail")
	@ResponseBody
	public String verifyEmail(HttpServletRequest request, @RequestParam("email") String email) {
		// 正则表达式邮箱格式
		String emailFormat = "^[a-zA-Z0-9_-]{5,20}+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
		Pattern pattern = Pattern.compile(emailFormat);
		Matcher matcher = pattern.matcher(email);
		boolean b = matcher.matches();
		List<User> listUser = this.registerServiceImpl.findAllUser();
		int temp=0;
		for (User u : listUser) {
			if (u.getEmail().equals(email)) {
				temp += 1;
			}
		}
		
		String result = "";
		if (b && temp==0) {
			result = "email pass";
			return result;
		} else if(b && temp==1){
			result = "email exist";
			return result;
		}else {
			result ="email not pass";
			return result;
		}
	}
	
	/**
	 * 
	    * @Title: verifyPassword
	    * @Description: TODO(验证密码输入格式)
	    * @param @param request
	    * @param @param password
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */

	@RequestMapping("/verifyPassword")
	@ResponseBody
	public String verifyPassword(HttpServletRequest request, @RequestParam("password") String password) {
		// 正则表达式限制密码长度
		String passwordFormat = "^[0-9a-zA-Z]\\w{5,17}$";
		Pattern pattern = Pattern.compile(passwordFormat);
		Matcher matcher = pattern.matcher(password);
		boolean b = matcher.matches();
		String result = "";
		if (b) {
			result = "password pass";
			return result;
		} else {
			result = "password not pass";
			return result;
		}
	}

	/**
	 * 
	 * @Title: registeUser @Description: TODO(用户注册) @param @param
	 *         request @param @param response @param @param email @param @param
	 *         password @param @param captcha_v @param @return @param @throws
	 *         IOException 参数 @return String 返回类型 @throws
	 */
	@RequestMapping("/register")
	public String registeUser(HttpServletRequest request, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("captcha_v") String captcha_v) throws IOException {

		// 邮箱格式判断
		String emailFormat = "^[a-zA-Z0-9_-]{5,20}+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
		Pattern pattern = Pattern.compile(emailFormat);
		Matcher matcher = pattern.matcher(email);
		boolean b = matcher.matches();

		// 密码格式判断
		String passwordFormat = "^[0-9a-zA-Z]\\w{5,17}$";
		Pattern pattern1 = Pattern.compile(passwordFormat);
		Matcher matcher1 = pattern1.matcher(password);
		boolean b1 = matcher1.matches();

		// 获取验证码
		String sb = (String) request.getSession().getAttribute("code");
		User user = new User();
		List<User> listUser = this.registerServiceImpl.findAllUser();
		int temp = 0;
		//获取用户流水号
		int num=listUser.size()+1;
		// 判断该Email是否与数据库的Email重复
		for (User u : listUser) {
			if (u.getEmail().equals(email)) {
				temp += 1;
			}
		}

		// 判断是否符合要求的格式
		if (b && temp == 0 && b1 && sb.equals(captcha_v)) {
			System.out.println("register");
			user.setEmail(email);
			user.setPassword(password);
			user.setPhoto("img/Linux&c.png");
			user.setNickName("小e"+num);
			this.registerServiceImpl.insertUser(user);
			return "redirect:/index";
		} else {
			return "index";
		}
	}
	/**
	 * 
	    * @Title: verifyUser
	    * @Description: TODO(验证用户登录信息)
	    * @param @param email
	    * @param @param request
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */

	@RequestMapping("/verifyUser")
	@ResponseBody
	public String verifyUser(@RequestParam("email") String email, HttpServletRequest request) {
		List<User> listUser = this.registerServiceImpl.findAllUser();
		int temp = 0;
		String result = "";
		for (User u : listUser) {
			if (u.getEmail().equals(email)) {
				result = "email can use";
				return result;
			} else {
				temp += 1;
			}
		}
		if (temp == listUser.size()) {
			result = "email not exist";
			return result;
		} else {
			result = "email error";
			return result;
		}

	}

	/**
	 * 
	 * @Title: loginUser @Description: TODO(用户登录) @param @param email @param @param
	 *         password @param @param request @param @param response @param @throws
	 *         IOException 参数 @return void 返回类型 @throws
	 */
	@RequestMapping("/login")
	@ResponseBody
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpServletRequest request) {
		List<User> listUser = this.registerServiceImpl.findAllUser();
		int temp = 0;
		String result = "false";
		for (User u : listUser) {
			if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
				result = "true";
				request.getServletContext().setAttribute("user", u);
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				request.getServletContext().setAttribute("loginFlag", 1);
				return result;
			} else {
				temp += 1;
			}
		}
		return result;
	}
	
	/**
	 * 
	    * @Title: quit
	    * @Description: TODO(退出登录)
	    * @param @param request
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("/quit")
	public String quit(HttpServletRequest request) {
		String email=(String) request.getSession().getAttribute("email");
		if(email != null) {
			HttpSession session=request.getSession();
			session.setAttribute("email", null);
			request.getServletContext().setAttribute("loginFlag", 0);
			return "index";
		}else {
			request.getServletContext().setAttribute("loginFlag", 0);
			return "index";
		}		
	}
}
