package com.user.service;

import com.common.util.AuthInfo;
import com.common.util.LoginCommand;
import com.common.util.RegisterRequest;

public interface UserService {
	void register(RegisterRequest regReq) throws Exception;
	
	AuthInfo loginAuth(LoginCommand loginCommand) throws Exception;

}
