package com.Luke.pro1;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Inject //주입하다
	@Named("loginDAO") //@Autowired써도 상관없습니다.
	private LoginDAO loginDAO;
	
	public LoginDTO login(LoginDTO dto) {
		
		
		
		return loginDAO.login(dto);
		
	}

}
