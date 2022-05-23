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
import phongkham.data.BacSiRepository;
import phongkham.model.BacSi;
import phongkham.service.BacSiService;


@Slf4j
@Controller

public class BacsiController {
	@Autowired
	private BacSiService bacsiService;
	
	
	@RequestMapping("/GDQL_Bacsi")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<BacSi> listBacSi = bacsiService.listAll(keyword);
		model.addAttribute("listBacSi", listBacSi);
		model.addAttribute("keyword", keyword);
		
		return "/Bacsi/GDQL_Bacsi";
	}

	@RequestMapping("/them_Bacsi")
	public String showNewBacSiPage(Model model) {
		BacSi bacsi = new BacSi();
		model.addAttribute("bacsi", bacsi);
		return "/Bacsi/them_Bacsi";
	}

	@RequestMapping(value = "/luu_Bacsi", method = RequestMethod.POST)
	public String saveBacSi(@Valid @ModelAttribute("bacsi") BacSi bacsi, Errors error) {
		if(error.hasErrors()) {
			return "/Bacsi/them_Bacsi";
		}
		bacsiService.save(bacsi);
		return "redirect:/GDQL_Bacsi";
	}
	
	@RequestMapping(value = "/luu_sua_Bacsi", method = RequestMethod.POST)
	public String saveSuaBacSi(@Valid @ModelAttribute("bacsi") BacSi bacsi, Errors error) {
		if(error.hasErrors()) {
			return "/Bacsi/sua_Bacsi";
		}
		bacsiService.save(bacsi);
		return "redirect:/GDQL_Bacsi";
	}


	@RequestMapping("/sua_Bacsi/{id}")
	public ModelAndView showEditBacSiPage(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("/Bacsi/sua_Bacsi");
		BacSi bacsi = bacsiService.get(Integer.valueOf(id));
		mav.addObject("bacsi", bacsi);
		return mav;
	}

	@RequestMapping("/xoa_Bacsi/{id}")
	public String deleteBacSi(@PathVariable(name = "id") String id) {
		bacsiService.delete(Integer.valueOf(id));
		return "redirect:/GDQL_Bacsi";
	}
	
	
	
	
	
}
