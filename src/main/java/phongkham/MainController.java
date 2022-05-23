package phongkham;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
	@GetMapping("/")
	public String hienThiGDMain(Model model) {
		return "index";
	}
	
	@RequestMapping("/team")
	public String showTeamPage(Model model) {
		return "/team";
	}
}
