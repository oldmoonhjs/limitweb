package com.control;

import java.util.Iterator;
import java.util.List;

import com.model.*;

public class UserService {
	public User login(String loginname,String loginpassword){
		BaseDAO bd = new BaseDAO();
		List<User> li = bd.select();
		
		Iterator<User> it = li.iterator();
		while(it.hasNext()){
			User user = it.next();
			if(user.getLoginname().equals(loginname) && user.getLoginpassword().equals(loginpassword)){
				return user;
			}	
		}
		return null;
	}
}
