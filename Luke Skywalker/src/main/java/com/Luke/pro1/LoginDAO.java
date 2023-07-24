package com.Luke.pro1;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("loginDAO")
public class LoginDAO {
	
	/*@Inject
	@Named("sqlSession")
	private SqlSession sqlSession;
	
public List<Map<String, Object>> loginList(){
		
		return sqlSession.selectList("login.loginList");
		
	}
	
	public void login(LoginDTO dto) {
		
		sqlSession.insert("login.login", dto);
		
	} 내가 작성한 코드*/
	
	@Autowired
	private SqlSession sqlSession;

	public LoginDTO login(LoginDTO dto) {
		
		return sqlSession.selectOne("login.login",dto);
		
	}

	
	
}
