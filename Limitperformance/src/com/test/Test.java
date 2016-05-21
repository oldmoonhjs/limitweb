package com.test;

import java.util.Iterator;
import java.util.List;

import com.model.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String loginname = "admin";
		String loginpassword = "admin";
		BaseDAO bd = new BaseDAO();
		List<User> li = bd.select();
		
		boolean re = false;
		
		Iterator<User> it = li.iterator();
		while(it.hasNext()){
			User buff = it.next();
			if(buff.getLoginname().equals(loginname) && buff.getLoginpassword().equals(loginpassword)){
				re = true;
			}	

		}
		System.out.println(re);

	}

}
