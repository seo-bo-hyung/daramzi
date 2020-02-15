package com.user.service;

import com.happy.util.AuthInfo;
import com.happy.util.LoginCommand;
import com.happy.util.RegisterRequest;

public interface UserService {
	void register(RegisterRequest regReq) throws Exception;
	
	AuthInfo loginAuth(LoginCommand loginCommand) throws Exception;

}
