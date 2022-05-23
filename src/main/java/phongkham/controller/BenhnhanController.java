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

import lombok.extern.slf4j.Slf4j;
import phongkham.model.BacSi;
import phongkham.model.BenhNhan;
import phongkham.service.BenhNhanService;

@Slf4j
@Controller
public class BenhnhanController {
	@Autowired
	private BenhNhanService benhNhanService;
	
	@RequestMapping("/GDQL_Benhnhan")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<BenhNhan> listBenhNhan = benhNhanService.listAll(keyword);
		model.addAttribute("listBenhNhan", listBenhNhan);
		model.addAttribute("keyword", keyword);
		
		return "/Benhnhan/GDQL_Benhnhan";
	}

	
	@RequestMapping("/them_Benhnhan")
	public String hienThithemBenhnhan(Model model) {
		BenhNhan benhnhan = new BenhNhan();
		model.addAttribute("benhnhan", benhnhan);
		return "/Benhnhan/them_Benhnhan";
	}
	
	@RequestMapping(value = "/luu_Benhnhan", method = RequestMethod.POST)
	public String saveBenhNhan(@Valid @ModelAttribute("benhnhan") BenhNhan benhnhan, Errors error) {
		if(error.hasErrors()) {
			return "/Benhnhan/them_Benhnhan";
		}
		benhNhanService.save(benhnhan);
		return "redirect:/GDQL_Benhnhan";
	}
	
	@RequestMapping(value = "/luu_sua_Benhnhan", method = RequestMethod.POST)
	public String saveSuaBenhNhan(@Valid @ModelAttribute("benhnhan") BenhNhan benhnhan, Errors error) {
		if(error.hasErrors()) {
			return "/Benhnhan/sua_Benhnhan";
		}
		benhNhanService.save(benhnhan);
		return "redirect:/GDQL_Benhnhan";
	}

	@RequestMapping("/sua_Benhnhan/{id}")
	public ModelAndView showEditBenhNhanPage(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("/Benhnhan/sua_Benhnhan");
		BenhNhan benhnhan = benhNhanService.get(Integer.valueOf(id));
		mav.addObject("benhnhan", benhnhan);
		return mav;
	}

	@RequestMapping("/xoa_Benhnhan/{id}")
	public String deleteBenhNhan(@PathVariable(name = "id") String id) {
		benhNhanService.delete(Integer.valueOf(id));
		return "redirect:/GDQL_Benhnhan";
	}
}
