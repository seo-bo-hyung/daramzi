package com.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.happy.exception.AlreadyExistingEmailException;
import com.happy.exception.AlreadyExistingIdException;
import com.happy.exception.IdPasswordNotMatchingException;
import com.happy.util.AuthInfo;
import com.happy.util.LoginCommand;
import com.happy.util.RegisterRequest;
import com.user.dao.UserDAO;
import com.user.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
 
    @Resource(name="userDAO")
    private UserDAO userDAO;
  
    @Override
    public void register(RegisterRequest regReq) throws Exception {
        UserVO email = userDAO.selectByEmail(regReq.getEmail());
        if(email!=null) {
            throw new AlreadyExistingEmailException(regReq.getEmail()+" is duplicate email.");
        }
        UserVO id = userDAO.selectById(regReq.getId());
        if(id!=null) {
            throw new AlreadyExistingIdException(regReq.getId()+" is duplicate id.");
        }
        userDAO.insertUser(regReq);
    }
    
    @Override
    public AuthInfo loginAuth(LoginCommand loginCommand) throws Exception {
        UserVO user = userDAO.selectById(loginCommand.getId());
        if(user == null) {
            throw new IdPasswordNotMatchingException();
        }
        if(!user.matchPassword(loginCommand.getPw())) {
            throw new IdPasswordNotMatchingException();
        }
        return new AuthInfo(user.getID(), user.getNAME(), user.getGRADE());
    }


	
}


