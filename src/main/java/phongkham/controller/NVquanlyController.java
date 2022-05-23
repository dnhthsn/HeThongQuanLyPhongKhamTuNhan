package phongkham.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import phongkham.model.BacSi;
import phongkham.model.Benh;
import phongkham.model.ThongKeBenh;
import phongkham.model.Thuoc;
import phongkham.model.ThuocDuocSuDung;
import phongkham.model.YTa;
import phongkham.model.HoSoKham;
import phongkham.model.HoSoKham_Thuoc;
import phongkham.model.LuongBacSi;
import phongkham.model.LuongYta;
import phongkham.service.BacSiService;
import phongkham.service.BenhService;
import phongkham.service.HoSoKhamService;
import phongkham.service.ThuocService;
import phongkham.service.YTaService;

@Controller
public class NVquanlyController {
	@Autowired
	private BenhService benhService;

	@Autowired
	private HoSoKhamService hskService;

	@Autowired
	private YTaService ytaService;

	@Autowired
	private BacSiService bacsiService;
	
	@Autowired
	private ThuocService thuocService;
	

	@RequestMapping("/GDChinhNVquanly")
	public String viewHomePage(Model model) {
		return "/NVquanly/GDChinhNVquanly";
	}

	@RequestMapping("/thongkebenh")
	public String showThongKeBenhPage(Model model, @Param("keyword") String keyword) {
		List<Benh> listBenh = benhService.listAllwithoutKeyword();
		model.addAttribute("listBenh", listBenh);
		if (keyword != null) {
			List<HoSoKham> listHoSoKham1 = hskService.listAllbyMonth(keyword);

			HashSet<String> data = new HashSet();  // lưu các giá trị không trùng nhau
			for (int i = 0; i < listHoSoKham1.size(); i++) {
				String str = listHoSoKham1.get(i).getTenbenh() + "," + listHoSoKham1.get(i).getMalankham() + "," + listHoSoKham1.get(i).getMabn();
				data.add(str);
			}
			keyword = "/" + keyword;  //  07/2021
			List<ThongKeBenh> listThongKeBenh = new ArrayList<ThongKeBenh>();
			for (int i = 0; i < listBenh.size(); i++) {
				int solanmac = 0;
				Iterator<String> datastr = data.iterator();
				while (datastr.hasNext()) {
					String str = datastr.next();
					String[] tokens = str.split(",");
					if ((listBenh.get(i).getTenbenh()).equals(tokens[0])) {
						solanmac++;
					}
				}
				ThongKeBenh tkb = new ThongKeBenh();
				//tkb.setMabenh(listBenh.get(i).getMabenh());
				tkb.setTenbenh(listBenh.get(i).getTenbenh());
				tkb.setLoaibenh(listBenh.get(i).getLoaibenh());
				tkb.setMota(listBenh.get(i).getMota());
				tkb.setSolanmac(solanmac);
				if (solanmac > 0) {
					listThongKeBenh.add(tkb);
				}

			}

			Collections.sort(listThongKeBenh, new Comparator<ThongKeBenh>() {

				public int compare(ThongKeBenh o1, ThongKeBenh o2) {
					return (o2.getSolanmac() + "").compareTo(o1.getSolanmac() + "");
				}
			});

			model.addAttribute("listTKB", listThongKeBenh);

		}


		return "/NVquanly/thongkebenhtheothang";
	}

	@RequestMapping("/tinhluongYta")
	public String showtinhLuongYtaPage(Model model, @Param("keyword") String keyword) {
		List<YTa> listYta = ytaService.listAllwithoutKeyword();
		model.addAttribute("listYta", listYta);
		List<HoSoKham> listHoSoKham = hskService.listAllwithoutKeyword();
		model.addAttribute("listhsk", listHoSoKham);

		if (keyword != null) {
			keyword = "/" + keyword;
			List<LuongYta> luongYta = new ArrayList<LuongYta>();
			for (int i = 0; i < listYta.size(); i++) {
				int solanhotro = 0;
				for (int j = 0; j < listHoSoKham.size(); j++) {
					if ((listYta.get(i).getMayt() + "").equals(listHoSoKham.get(j).getMayt() + "")
							&& listHoSoKham.get(j).getNgayvaovien().contains(keyword)) {
						solanhotro++;

					}
				}
				LuongYta lyta = new LuongYta();
				lyta.setMayt(listYta.get(i).getMayt());
				lyta.setTenyt(listYta.get(i).getTenyt());
				lyta.setLuong(5000000 + 200000 * solanhotro);
				luongYta.add(lyta);
			}
			model.addAttribute("listluongYta", luongYta);
		}

		return "/NVquanly/tinhluongyta";
	}

	@RequestMapping("/tinhluongBacsi")
	public String showtinhLuongBacsiPage(Model model, @Param("keyword") String keyword) {
		List<BacSi> listBacsi = bacsiService.listAllwithoutKeyword();
		model.addAttribute("listBacsi", listBacsi);
		List<HoSoKham> listHoSoKham = hskService.listAllwithoutKeyword();
		model.addAttribute("listhsk", listHoSoKham);
		List<LuongBacSi> luongBacsi = new ArrayList<LuongBacSi>();
		if (keyword != null) {
			keyword = "/" + keyword;
			List<String> data1 = new ArrayList<String>();
			List<HoSoKham> listDakhoiTrongthang = new ArrayList<HoSoKham>();
			for (int i = 0; i < listHoSoKham.size(); i++) {
				if ((listHoSoKham.get(i).getTrangthai()).equals("Đã khỏi")
						&& (listHoSoKham.get(i).getNgayravien()).contains(keyword)) {
					listDakhoiTrongthang.add(listHoSoKham.get(i));
					String str = listHoSoKham.get(i).getTenbenh() + "," + listHoSoKham.get(i).getMalankham() + ","
							+ listHoSoKham.get(i).getMabs() + "," + listHoSoKham.get(i).getMabn();
					data1.add(str);
				}

			}

			List<String> data2 = new ArrayList<String>();
			for (int i = 0; i < data1.size(); i++) {
				int dem = 0;
				String[] tokens = (data1.get(i)).split(",");
				for (int j = 0; j < listHoSoKham.size(); j++) {
					if ((listHoSoKham.get(j).getTrangthai()).equals("Chưa khỏi")
							&& (listHoSoKham.get(j).getMabn() + "").equals(tokens[3])
							&& !(listHoSoKham.get(j).getMabs() + "").equals(tokens[2])
							&& (listHoSoKham.get(j).getTenbenh()).equals(tokens[0])
							&& (listHoSoKham.get(j).getMalankham() + "").equals(tokens[1])) {
						dem++;

					}
				}
				if (dem == 0) {
					data2.add(data1.get(i));
				}
			}

			for (int i = 0; i < listBacsi.size(); i++) {
				int solankham = 0;
				for (int j = 0; j < data2.size(); j++) {
					String[] tokens2 = (data2.get(j)).split(",");

					if ((listBacsi.get(i).getMabs() + "").equals(tokens2[2])) {
						solankham++;

					}
				}
				LuongBacSi lbs = new LuongBacSi();
				lbs.setMabs(listBacsi.get(i).getMabs());
				lbs.setTenbs(listBacsi.get(i).getTenbs());
				lbs.setLuong(7000000 + 1000000 * solankham);
				luongBacsi.add(lbs);
			}
			model.addAttribute("listluongBacsi", luongBacsi);
		}
		return "/NVquanly/tinhluongbacsi";
	}
	
	
	
	
}
