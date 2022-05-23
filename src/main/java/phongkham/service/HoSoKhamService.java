package phongkham.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import phongkham.data.HoSoKhamRepository;
import phongkham.model.HoSoKham;

@Service
@Transactional
public class HoSoKhamService {
	@Autowired
	private HoSoKhamRepository hskRepo;

	public List<HoSoKham> listAll(Integer keyword) {
		if (keyword != null) {
			return hskRepo.findAll(keyword);
		}
		return hskRepo.findAll();
	}

	public List<HoSoKham> listAllbyMonth(String keyword) {
		return hskRepo.findAllbyMonth(keyword);
	}

	public List<HoSoKham> listAllwithoutKeyword() {
		return hskRepo.findAll();
	}

	public void save(HoSoKham hsk) {
		hskRepo.save(hsk);
	}

	public HoSoKham get(int id) {
		return hskRepo.findById((long) id).orElse(null);
	}

	public void delete(int id) {
		hskRepo.deleteById((long) id);
	}

	public List<HoSoKham> getAllByIdIn(List<Long> listBacSiId) {
		return hskRepo.findAllById(listBacSiId);
	}
}
