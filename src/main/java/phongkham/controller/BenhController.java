package phongkham.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import phongkham.model.Benh;
import phongkham.service.BenhService;

@Controller
public class BenhController {
	
	@Autowired
	private BenhService benhService;
	
	@RequestMapping("/GDQL_Benh")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<Benh> listBenh = benhService.listAll(keyword);
		model.addAttribute("listBenh", listBenh);
		model.addAttribute("keyword", keyword);
		return "/Benh/GDQL_Benh";
	}
	
	@RequestMapping("/them_Benh")
	public String showNewBenhPage(Model model) {
		Benh benh = new Benh();
		model.addAttribute("benh", benh);
		return "/Benh/them_Benh";
	}

	@RequestMapping(value = "/luu_Benh", method = RequestMethod.POST)
	public String saveBenh(@Valid @ModelAttribute("benh") Benh benh, Errors error) {
		if(error.hasErrors()) {
			return "/Benh/them_Benh";
		}
		benhService.save(benh);
		return "redirect:/GDQL_Benh";
	}
	
	@RequestMapping(value = "/luu_sua_Benh", method = RequestMethod.POST)
	public String saveSuaBenh(@Valid @ModelAttribute("benh") Benh benh, Errors error) {
		if(error.hasErrors()) {
			return "/Benh/sua_Benh";
		}
		benhService.save(benh);
		return "redirect:/GDQL_Benh";
	}

	@RequestMapping("/sua_Benh/{id}")
	public ModelAndView showEditBenhPage(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("/Benh/sua_Benh");
		Benh benh = benhService.get(id);
		mav.addObject("benh", benh);
		return mav;
	}

	@RequestMapping("/xoa_Benh/{id}")
	public String deleteBenh(@PathVariable(name = "id") String id) {
		benhService.delete(id);
		return "redirect:/GDQL_Benh";
	}
}