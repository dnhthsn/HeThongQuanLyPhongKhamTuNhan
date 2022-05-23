package phongkham.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phongkham.data.ThuocRepository;
import phongkham.model.Thuoc;

@Service
@Transactional
public class ThuocService {
	@Autowired
	private ThuocRepository thuocRepo;

	public List<Thuoc> listAll(String keyword) {
		if (keyword != null) {
			return thuocRepo.findAll(keyword);
		}
		return thuocRepo.findAll();
	}

	public List<Thuoc> listUsedMedicine(Integer keyword) {
		return thuocRepo.findUsedMedicine(keyword);
	}
	
	public List<Thuoc> listAllwithoutKeyword(){
		return thuocRepo.findAll();
	}
	
	public float getGiaThuoc(String keyword) {
		return thuocRepo.getGiaByName(keyword);
	}

	public void save(Thuoc thuoc) {
		thuocRepo.save(thuoc);
	}

	public Thuoc get(String id) {
		return thuocRepo.findById(id).orElse(null);
	}

	public void delete(String id) {
		thuocRepo.deleteById(id);
	}

	public List<Thuoc> getAllByIdIn(List<String> listThuocId) {
		return thuocRepo.findAllById(listThuocId);
	}
}