package kr.co.sist;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	@RequestMapping(value = "user/mainContents/mainContents.do", method = GET)
	public String guestReportPage() {

		return "user/mainContents/mainContents";
	}// reportPage
}
