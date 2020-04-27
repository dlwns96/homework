package com.tech.aPrj6;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieController {

	@RequestMapping("/movie/movieForm")
	public String movieform() {
	
		return "/movie/movieForm";
	}
	
	@RequestMapping("/movie/movieView")
	public ModelAndView movieView(HttpServletRequest request) {
		
		String mTitle = request.getParameter("title");
		String mActor = request.getParameter("actor");
		String mDate = request.getParameter("date");
		ModelAndView mv = new ModelAndView();
	
		mv.addObject("mTitle", mTitle);
		mv.addObject("mActor", "mActor");
		mv.addObject("mDate", "mDate");
		
		mv.setViewName("movie/movieView");
		
		return mv;
		
		
		
	}
		
}
