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
import phongkham.model.Thuoc;
import phongkham.service.ThuocService;
@Controller
public class ThuocController {
	
	@Autowired
	private ThuocService thuocService;
	
	@RequestMapping("/GDQL_Thuoc")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<Thuoc> listThuoc = thuocService.listAll(keyword);
		model.addAttribute("listThuoc", listThuoc);
		model.addAttribute("keyword", keyword);
		return "/Thuoc/GDQL_Thuoc";
	}
	
	@RequestMapping("/them_Thuoc")
	public String showNewThuocPage(Model model) {
		Thuoc thuoc = new Thuoc();
		model.addAttribute("thuoc", thuoc);
		return "/Thuoc/them_Thuoc";
	}

	@RequestMapping(value = "/luu_Thuoc", method = RequestMethod.POST)
	public String saveThuoc(@Valid @ModelAttribute("thuoc") Thuoc thuoc, Errors error) {
		if(error.hasErrors()) {
			return "/Thuoc/them_Thuoc";
		}
		thuocService.save(thuoc);
		return "redirect:/GDQL_Thuoc";
	}
	
	@RequestMapping(value = "/luu_sua_Thuoc", method = RequestMethod.POST)
	public String saveSuaThuoc(@Valid @ModelAttribute("thuoc") Thuoc thuoc, Errors error) {
		if(error.hasErrors()) {
			return "/Thuoc/sua_Thuoc";
		}
		thuocService.save(thuoc);
		return "redirect:/GDQL_Thuoc";
	}
	
	

	@RequestMapping("/sua_Thuoc/{id}")
	public ModelAndView showEditThuocPage(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("/Thuoc/sua_Thuoc");
		Thuoc thuoc = thuocService.get(id);
		mav.addObject("thuoc", thuoc);
		return mav;
	}

	@RequestMapping("/xoa_Thuoc/{id}")
	public String deleteThuoc(@PathVariable(name = "id") String id) {
		thuocService.delete(id);
		return "redirect:/GDQL_Thuoc";
	}
}