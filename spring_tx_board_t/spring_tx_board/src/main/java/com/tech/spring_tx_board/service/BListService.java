package com.tech.spring_tx_board.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.tech.spring_tx_board.dao.BoardDao;
import com.tech.spring_tx_board.dto.BoardDto;

public class BListService implements BServiceInp{

	@Override
	public void execute(Model model) {
		System.out.println("BListService execute");
		//실제 db접속으로
		BoardDao dao=new BoardDao();//BoardDao기본생성자호출
		ArrayList<BoardDto> dtos=dao.list();
		model.addAttribute("list", dtos);
	}

}
