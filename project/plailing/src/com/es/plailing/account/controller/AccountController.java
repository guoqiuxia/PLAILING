package com.es.plailing.account.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.es.plailing.account.service.AccountServiceImpl;
import com.es.plailing.entity.Money;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserBalance;

/*
 * 
    * @ClassName: AccountController
    * @Description: TODO(balance鎺у埗鍣紝璐熻矗璺宠浆service鏌ヨ鐢ㄦ埛娑堣垂鍏呭��/鏀剁泭璁板綍)
    * @author zhangsijia
    * @date 2018骞�12鏈�4鏃�
    *
 */
@Controller
@RequestMapping("user")
public class AccountController {

	@Resource
	private AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
	
	/**
	 * @throws Exception 
	 * 
	    * @Title: findBalance
	    * @Description: TODO(杩欓噷鐢ㄤ竴鍙ヨ瘽鎻忚堪杩欎釜鏂规硶鐨勪綔鐢�)
	    * @param @param id
	    * @param @param model
	    * @param @return    鍙傛暟
	    * @return String    杩斿洖绫诲瀷
	    * @throws
	 */
	@RequestMapping("/finance")
	public String findBalance(HttpServletRequest request,
			@RequestParam(value="balancePageNum",defaultValue="1") int balancePageNum) throws Exception {
		//鑾峰彇鐢ㄦ埛韬唤
		String userEmail = (String)request.getSession().getAttribute("email");
		
		//褰撳墠鐢ㄦ埛浣欓
		double nowTotleBalance = accountServiceImpl.findNowTotleBalance(userEmail);
		
		//鐢ㄦ埛鍏呭�兼秷璐硅褰�
		Page<UserBalance> userBalanceListPage = new Page<UserBalance>();
		userBalanceListPage = accountServiceImpl.findBalance(balancePageNum, 10, userEmail);
		
		request.getSession().setAttribute("nowTotleBalance", nowTotleBalance);
		
		request.getSession().setAttribute("userBalanceListPage", userBalanceListPage);
		return "account";
	}
	
	
	@RequestMapping("/money")
	public String findMoney(HttpServletRequest request,
			@RequestParam(value="moneyPageNum",defaultValue="1") int moneyPageNum) throws Exception {
		//鑾峰彇鐢ㄦ埛韬唤
		String userEmail = (String)request.getSession().getAttribute("email");
		
		//褰撳墠鐢ㄦ埛鎬绘敹鐩�
		double userNowTotleEarning =  accountServiceImpl.findUserNowTotleEaring(userEmail);
		
		//鐢ㄦ埛寮�璇炬敹鐩�
		Page<Object[]> moneyListPage = new Page<Object []>();
		moneyListPage = accountServiceImpl.findMoney(moneyPageNum, 10, userEmail);
		
		
		request.getSession().setAttribute("userNowTotleEarning", userNowTotleEarning);
		
		request.getSession().setAttribute("moneyListPage", moneyListPage);
		return "account2";
	}
}
