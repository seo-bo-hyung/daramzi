package com.board.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*import com.board.mybatis.BoardManager;*/
import com.board.service.BoardService;
 
@Controller
public class AjaxController {
    @Resource(name="boardService")
    private BoardService boardService;
    
    @RequestMapping(value="/boardAjax.action")
    public void ajaxlist(HttpServletRequest req, HttpServletResponse res) 
            throws IOException{
        int seq = Integer.parseInt(req.getParameter("seq"));
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html; charset=utf-8");
        res.setHeader("Cache-Control", "no-cache");
        
		/*
		 * String preContent = BoardManager.preView(seq); PrintWriter out
		 * =res.getWriter(); out.print(preContent);
		 */
    }
}
