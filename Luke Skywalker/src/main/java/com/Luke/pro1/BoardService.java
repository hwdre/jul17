package com.Luke.pro1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

//이게 없으면 그냥 BoardService 타입으로 저장되지만 뒤에 이걸 넣으면 
//boardService라는 이름이 생깁니다.
@Service("boardService") 
public class BoardService {
	
	@Inject //주입하다
	@Named("boardDAO")
	private BoardDAO boardDAO;
	
	//보드리스트 불러오는 메소드
	public List<Map<String, Object>> boardList(){
		
		return boardDAO.boardList();
		
	}

	public BoardDTO detail(String bno) {
		
		return boardDAO.detail(bno);
		
	}
	
}
