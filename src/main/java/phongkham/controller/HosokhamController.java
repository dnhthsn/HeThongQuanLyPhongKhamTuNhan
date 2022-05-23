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

import phongkham.model.BacSi;
import phongkham.model.Benh;
import phongkham.model.BenhNhan;
import phongkham.model.HoSoKham;
import phongkham.model.Thuoc;
import phongkham.model.YTa;
import phongkham.service.BacSiService;
import phongkham.service.BenhNhanService;
import phongkham.service.BenhService;
import phongkham.service.HoSoKhamService;
import phongkham.service.ThuocService;
import phongkham.service.YTaService;


@Controller
public class HosokhamController {
	@Autowired
	private HoSoKhamService hskService;
	
	@Autowired
	private BacSiService bacsiService;
	
	@Autowired
	private YTaService ytaService;
	
	@Autowired
	private BenhNhanService bnService;
	
	@Autowired
	private ThuocService thuocService;
	
	@Autowired
	private BenhService benhService;
	
	@RequestMapping("/GDQL_Hosokham")
	public String viewHomePage(Model model, @Param("keyword") Integer keyword) {
		List<HoSoKham> listhsk = hskService.listAll(keyword);
		model.addAttribute("listhsk", listhsk);
		model.addAttribute("keyword", keyword);
		
		return "/Hosokham/GDQL_Hosokham";
	}
	
	@RequestMapping("/them_Hosokham")
	public String showNewHoSoKhamPage(Model model, @Param("keyword") String keyword) {
		List<BacSi> listBacSi = bacsiService.listAll(keyword);
		model.addAttribute("listBacSi", listBacSi);
		List<YTa> listYTa = ytaService.listAll(keyword);
		model.addAttribute("listYta", listYTa);
		List<BenhNhan> listbn = bnService.listAll(keyword);
		model.addAttribute("listbn", listbn);
		List<Thuoc> listThuoc = thuocService.listAll(keyword);
		model.addAttribute("listThuoc", listThuoc);
		List<Benh> listBenh = benhService.listAll(keyword);
		model.addAttribute("listBenh", listBenh);
		
		
		HoSoKham hsk = new HoSoKham();
		model.addAttribute("hsk", hsk);
		return "/Hosokham/them_Hosokham";
	}
	
	@RequestMapping(value = "/luu_Hosokham", method = RequestMethod.POST)
	public String saveHoSoKham(Model model, @Valid @ModelAttribute("hsk") HoSoKham hsk, Errors error, @Param("keyword") String keyword) {
		List<BacSi> listBacSi = bacsiService.listAll(keyword);
		model.addAttribute("listBacSi", listBacSi);
		List<YTa> listYTa = ytaService.listAll(keyword);
		model.addAttribute("listYta", listYTa);
		List<BenhNhan> listbn = bnService.listAll(keyword);
		model.addAttribute("listbn", listbn);
		List<Thuoc> listThuoc = thuocService.listAll(keyword);
		model.addAttribute("listThuoc", listThuoc);
		List<Benh> listBenh = benhService.listAll(keyword);
		model.addAttribute("listBenh", listBenh);
		
		if(error.hasErrors()) {
			return "/Hosokham/them_Hosokham";
		}
		hskService.save(hsk);
		return "redirect:/GDQL_Hosokham";
	}
	
	@RequestMapping(value = "/luu_sua_Hosokham", method = RequestMethod.POST)
	public String saveSuaHoSoKham(Model model, @Valid @ModelAttribute("hsk") HoSoKham hsk, Errors error, @Param("keyword") String keyword) {
		List<BacSi> listBacSi = bacsiService.listAll(keyword);
		model.addAttribute("listBacSi", listBacSi);
		List<YTa> listYTa = ytaService.listAll(keyword);
		model.addAttribute("listYta", listYTa);
		List<BenhNhan> listbn = bnService.listAll(keyword);
		model.addAttribute("listbn", listbn);
		List<Thuoc> listThuoc = thuocService.listAll(keyword);
		model.addAttribute("listThuoc", listThuoc);
		List<Benh> listBenh = benhService.listAll(keyword);
		model.addAttribute("listBenh", listBenh);
		
		if(error.hasErrors()) {
			return "/Hosokham/sua_Hosokham";
		}
		hskService.save(hsk);
		return "redirect:/GDQL_Hosokham";
	}

	@RequestMapping("/sua_Hosokham/{id}")
	public ModelAndView showEditHoSoKhamPage(@PathVariable(name = "id") String id, @Param("keyword") String keyword, Model model) {
		List<BacSi> listBacSi = bacsiService.listAll(keyword);
		model.addAttribute("listBacSi", listBacSi);
		List<YTa> listYTa = ytaService.listAll(keyword);
		model.addAttribute("listYta", listYTa);
		List<BenhNhan> listbn = bnService.listAll(keyword);
		model.addAttribute("listbn", listbn);
		List<Thuoc> listThuoc = thuocService.listAll(keyword);
		model.addAttribute("listThuoc", listThuoc);
		List<Benh> listBenh = benhService.listAll(keyword);
		model.addAttribute("listBenh", listBenh);
		
		ModelAndView mav = new ModelAndView("/Hosokham/sua_Hosokham");
		HoSoKham hsk = hskService.get(Integer.valueOf(id));
		mav.addObject("hsk", hsk);
		return mav;
	}
	
	
	@RequestMapping("/bangkedon/{id}")
	public ModelAndView showbangkedonPage(@PathVariable(name = "id") String id, @Param("keyword") Integer keyword, Model model) {
		List<Thuoc> listThuoc = thuocService.listUsedMedicine(Integer.valueOf(id));
		model.addAttribute("listThuoc", listThuoc);
		
		ModelAndView mav = new ModelAndView("/Hosokham/bangkedon");
		HoSoKham hsk = hskService.get(Integer.valueOf(id));
		mav.addObject("hsk", hsk);
		return mav;
	}
	
}
