package com.rcp.example.module.b.client;

import com.rcp.example.moudle.a.accessible.AccesibleClass;
import com.rcp.example.moudle.a.internal.InternalClass;
import com.rcp.example.moudle.a.internalfriends.InternalWithFriendsClass;

public class TestAccessRules {

	public static void main(String[] args) {
		new AccesibleClass().exe();
		
		//new ForbiddenClass().exe();
		
		new InternalClass().exe();
		
		new InternalWithFriendsClass().exe();
	}
}
