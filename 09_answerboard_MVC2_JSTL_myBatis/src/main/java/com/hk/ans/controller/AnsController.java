package com.hk.ans.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.ans.daos.AnswerDao;
import com.hk.ans.dtos.AnswerDto;

@WebServlet("*.board")
public class AnsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//command 값 구하기
		//9_answerboard_MVC_JSTL_maBatis/*.board
		//9_answerboard_MVC_JSTL_maBatis
		// --->                         "/*.board" 구하기 위함
		String command=request.getRequestURI()
				              .substring(request.getContextPath().length());
	
		System.out.println("요청내용:"+command);
		AnswerDao dao=new AnswerDao();
		
		if(command.equals("/boardlist.board")) {
			
			//페이지번호 받기
			String pnum=request.getParameter("pnum");
			
			List<AnswerDto> list=dao.getAllList(pnum);
			request.setAttribute("list", list);
			
			//페이지수
			int pcount=dao.getPCount();
			request.setAttribute("pcount", pcount);
			
			request.getRequestDispatcher("boardlist.jsp")
			       .forward(request, response);
		}else if(command.equals("/insertform.board")) {//글추가폼이동
			response.sendRedirect("insertboardform.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}