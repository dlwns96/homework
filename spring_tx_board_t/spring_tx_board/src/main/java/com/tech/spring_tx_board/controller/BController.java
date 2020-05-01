package com.tech.spring_tx_board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.spring_tx_board.service.BListService;
import com.tech.spring_tx_board.service.BServiceInp;

@Controller
public class BController {
	BServiceInp commandInp;

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("pass list()");
		//db에서 데이터추출 list에 전송
		commandInp=new BListService();
		commandInp.execute(model);
		
		return "list";
	}
}
