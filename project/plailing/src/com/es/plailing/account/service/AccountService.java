package com.es.plailing.account.service;

import com.es.plailing.entity.Page;
import com.es.plailing.entity.UserBalance;

public interface AccountService {
	public Page<UserBalance> findBalance(int pageNum, int pageSize,String email) throws Exception;
	public double findNowTotleBalance (String email)throws Exception;
	public Page<Object[]> findMoney(int pageNum, int pageSize,String email)throws Exception;
	public double findUserNowTotleEaring(String email)throws Exception;
}
