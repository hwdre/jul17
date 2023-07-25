package com.Luke.pro1;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	// user -> Controller -> Service -> DAO -> mybatis ->DB

	// autowired말고 Resource로 연결
	@Resource(name = "boardService")
	private BoardService boardService;

	@Autowired
	private Util util; // 숫자변환을 사용하기위한 객체를 연결했습니다.

	@GetMapping("/board")
	public String board(Model model) {
		// 서비스에서 값 가져오기

		model.addAttribute("list", boardService.boardList());

		return "board";

	}

	// http://localhost:8080/pro1/detail?bno=426
	// 파라미터로 들어오는 값 잡기
	@GetMapping("/detail")
	public String detail(HttpServletRequest request, Model model) {

		// String bno = request.getParameter("bno");
		// bno에 요청하는 값이 있습니다. 이 값을 db까지 보내겠습니다.
		// System.out.println("bno: " + bno);
		int bno = util.sti(request.getParameter("bno"));

		BoardDTO dto = new BoardDTO();
		dto.setBno(bno);

		BoardDTO resultdto = boardService.detail(dto);
		model.addAttribute("dto", resultdto);
		return "detail";
	}

	@GetMapping("/write")
	public String write(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if (session.getAttribute("mname") != null) {
			return "write";
		} else {
			return "redirect:/login";
		}
	}

	@PostMapping("/write")
	public String write2(HttpServletRequest request) {
		// 사용자가 입력한 데이터 변수에 담기
		// System.out.println(request.getParameter("title"));
		// System.out.println(request.getParameter("content"));
		// System.out.println("==============================");
		// Service ->DAO -> mybatis ->DB로 보내서 저장하기

		// 상대 ip 가져오기 23-07-19
		// HttpServletRequest가 있어야 합니다.

		HttpSession session = request.getSession();
		if (session.getAttribute("mid") != null) {

			// 로그인 했습니다. = 아래 로직을 여기로 가져오세요.
			BoardDTO dto = new BoardDTO();
			dto.setBtitle(request.getParameter("title"));
			dto.setBcontent(request.getParameter("content"));
			dto.setM_id((String) session.getAttribute("mid")); // 임시값
			dto.setM_name((String) session.getAttribute("mname"));

			// service-> dao -> mybatis-> db
			boardService.write(dto);

			return "redirect:/board"; // 다시 컨트롤러 지나가기 GET방식으로 지나갑니다.

		} else {

			// 로그인 안했어요. = 로그인 하세요.
			return "redirect:/login";

		}

	}

	@GetMapping("/delete")
	public String delete(@RequestParam(value = "bno", required = false, defaultValue = "0") int bno, HttpSession session) {
		//로그인 여부 확인해주세요.
		//System.out.println("mid: " + session.getAttribute("mid"));
	
		BoardDTO dto = new BoardDTO();
		dto.setBno(bno);
		dto.setM_id((String) session.getAttribute("mid"));
		// dto.setBwrite(null); 지금 이 게시글을 삭제하려는 사람이 누구인지 담아서 보냅니다.
		// 나중에 로그인을 하면 사용자의 정보도 담아서 보냅니다.

		boardService.delete(dto);

		return "redirect:/board";

	}

	@GetMapping("/edit")
	public ModelAndView edit(HttpServletRequest request) {
		// 로그인하지 않으면 로그인 화면으로 던져주세요.
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("mid") != null) {

			// if문으로 만들어주세요.

			// dto를 하나 만들어서 거기에 담겠습니다.
			BoardDTO dto = new BoardDTO();
			dto.setBno(util.sti(request.getParameter("bno")));
			// 내 글만 수정할 수 있도록 세션에 있는 mid도 보냅니다.
			dto.setM_id((String) session.getAttribute("mid"));

			// 데이터베이스에 bno를 보내서 dto를 얻어옵니다.
			BoardDTO resultdto = boardService.detail(dto);
			if(resultdto != null) {
				// mv에 실어보냅니다.
				mv.addObject("dto",resultdto);
				mv.setViewName("edit"); // 이동할 jsp명을 적어줍니다.
			} else {
				mv.setViewName("warning");
			}
		} else {
			mv.setViewName("redirect:/login");
			// 로그인 안했어요. = 로그인 하세요.

		}
		return mv;
	}

	@PostMapping("/edit")
	public String edit(BoardDTO dto) {

		// System.out.println(map);

		// System.out.println(dto.getBtitle());
		// System.out.println(dto.getBcontent());
		// System.out.println(dto.getBno());

		boardService.edit(dto);

		return "redirect:/detail?bno=" + dto.getBno(); // 보드로 이동하겠습니다.

	}

}
