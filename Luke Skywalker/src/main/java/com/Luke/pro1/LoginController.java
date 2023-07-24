package com.Luke.pro1;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login(HttpServletRequest request) {

		LoginDTO dto = new LoginDTO();
		dto.setM_id(request.getParameter("id"));
		dto.setM_pw(request.getParameter("pw"));
		// 생각해주세요. id/pw를 보냈을 때 무엇이 왔으면 좋을까요?
		// 이름 + count(*)
		LoginDTO result = loginService.login(dto);

		// System.out.println(result.getM_name());
		// System.out.println(result.getCount());

		if (result.getCount() == 1) {
			// 세션을 만들어서 로그인을 지정 시간동안 유지시킵니다.
			HttpSession session = request.getSession();
			session.setAttribute("mname", result.getM_name());
			session.setAttribute("mid", request.getParameter("id"));
			// 세션: 서버, 쿠키: 클라이언트
			return "redirect:index"; // 로그인이 되면 인덱스로 갑니다.

		} else {

			return "login"; // 로그인이 되지 않으면 로그인화면이 뜹니다.

		}

	}

	@GetMapping("/logout")
	public String logout(HttpSession httpSession) {
		System.out.println("11:");

		if (httpSession.getAttribute("mname") != null) {
		
			//httpSession.invalidate(); // 세션 삭제하기
			httpSession.removeAttribute("mname"); //세션 삭제하기
			
		}
		if (httpSession.getAttribute("mid") != null) {
			
			//httpSession.invalidate(); // 세션 삭제하기
			httpSession.removeAttribute("mid"); //세션 삭제하기
			
		}
		
		httpSession.setMaxInactiveInterval(0); //세션 유지시간을 0으로 = 종료시키기
		
		httpSession.invalidate(); //세션 초기화 = 종료 = 세션의 모든 속성값을 제거
		
		return "redirect:index";

	}

}
