package phongkham.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import phongkham.data.BenhNhanRepository;
import phongkham.model.BacSi;
import phongkham.model.BenhNhan;

@Service
@Transactional
public class BenhNhanService {
	@Autowired
	private BenhNhanRepository benhNhanRepo;
	
	public List<BenhNhan> listAll(String keyword){
		if(keyword != null) {
			return benhNhanRepo.findAll(keyword);
		}
		
		return benhNhanRepo.findAll();
	}
	
	
	public void save(BenhNhan benhnhan) {
		benhNhanRepo.save(benhnhan);
	}
	
	public BenhNhan get(int id) {
		return benhNhanRepo.findById((long) id).orElse(null);
	}
	
	public void delete(int id) {
		benhNhanRepo.deleteById((long) id);
	}

	public List<BenhNhan> getAllByIdIn(List<Long> listBacSiId) {
		return benhNhanRepo.findAllById(listBacSiId);
	}
}
