package com.tech.aPrj6;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CarController {

	@RequestMapping("/car/carForm")
		public String carform() {
		
			return "/car/carForm";
		}
		
		@RequestMapping("/car/carView")
		public String carview(HttpServletRequest request, Model model) {
			String cName = request.getParameter("name");
			String cColor = request.getParameter("color");
			String cKind = request.getParameter("kind");
			
			model.addAttribute("cName", cName);
			model.addAttribute("cColor", cColor);
			model.addAttribute("cKind", cKind);

			
			return "/car/carView";
		}
	
}
