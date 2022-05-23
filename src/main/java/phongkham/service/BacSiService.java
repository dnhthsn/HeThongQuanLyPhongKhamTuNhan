package phongkham.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import phongkham.data.BacSiRepository;
import phongkham.model.BacSi;

@Service
@Transactional
public class BacSiService {
	@Autowired
	private BacSiRepository bacsiRepo;
	
	public List<BacSi> listAll(String keyword){
		if(keyword != null) {
			return bacsiRepo.findAll(keyword);
		}
		return bacsiRepo.findAll();
	}
	
	public List<BacSi> listAllwithoutKeyword(){
		return bacsiRepo.findAll();
	} 
	
	public void save(BacSi bacsi) {
		bacsiRepo.save(bacsi);
	}
	
	public BacSi get(int id) {
		return bacsiRepo.findById((long) id).orElse(null);
	}
	
	public void delete(int id) {
		bacsiRepo.deleteById((long) id);
	}

	public List<BacSi> getAllByIdIn(List<Long> listBacSiId) {
		return bacsiRepo.findAllById(listBacSiId);
	}
}
