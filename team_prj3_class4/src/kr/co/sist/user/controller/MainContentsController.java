package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainContentsController {

	@RequestMapping(value="/mainContents/.do", method=GET)
	public String showContentsForm(Model model) {
		return "mainContents/";
	}//showContentsForm
	
	//XXXX
}//class
