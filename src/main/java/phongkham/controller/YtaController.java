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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import phongkham.data.YTaRepository;
import phongkham.model.BacSi;
import phongkham.model.YTa;
import phongkham.service.YTaService;


@Slf4j
@Controller

public class YtaController {
	@Autowired
	private YTaService ytaService;
	
	
	@RequestMapping("/GDQL_Yta")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<YTa> listYTa = ytaService.listAll(keyword);
		model.addAttribute("listYTa", listYTa);
		model.addAttribute("keyword", keyword);
		
		return "/Yta/GDQL_Yta";
	}
	
	@RequestMapping("/them_Yta")
	public String showNewYTaPage(Model model) {
		YTa yta = new YTa();
		model.addAttribute("yta", yta);
		return "/Yta/them_Yta";
	}

	@RequestMapping(value = "/luu_Yta", method = RequestMethod.POST)
	public String saveYta(@Valid @ModelAttribute("yta") YTa yta, Errors error) {
		if(error.hasErrors()) {
			return "/Yta/them_Yta";
		}
		ytaService.save(yta);
		return "redirect:/GDQL_Yta";
	}
	
	@RequestMapping(value = "/luu_sua_Yta", method = RequestMethod.POST)
	public String saveSuaYta(@Valid @ModelAttribute("yta") YTa yta, Errors error) {
		if(error.hasErrors()) {
			return "/Yta/sua_Yta";
		}
		ytaService.save(yta);
		return "redirect:/GDQL_Yta";
	}

	@RequestMapping("/sua_Yta/{id}")
	public ModelAndView showEditYTaPage(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("/Yta/sua_Yta");
		YTa yta = ytaService.get(Integer.valueOf(id));
		mav.addObject("yta", yta);
		return mav;
	}

	@RequestMapping("/xoa_Yta/{id}")
	public String deleteYTa(@PathVariable(name = "id") String id) {
		ytaService.delete(Integer.valueOf(id));
		return "redirect:/GDQL_Yta";
	}
	
	
	
	
	
}
