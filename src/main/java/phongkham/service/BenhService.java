package phongkham.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import phongkham.data.BenhRepository;
import phongkham.model.Benh;
//import phongkham.model.ThongKeBenh;

@Service
@Transactional
public class BenhService {
	@Autowired
	private BenhRepository benhRepo;
	
	public List<Benh> listAll(String keyword){
		if(keyword != null) {
			return benhRepo.findAll(keyword);
		}
		return benhRepo.findAll();
	}
	
	public List<Benh> listAllwithoutKeyword(){
		
		return benhRepo.findAll();
	}
	
//	public ThongKeBenh getSoLanMacinMonth(String thangnam, String tenbenh) {
//		return benhRepo.getSoLanMacTrongThang(thangnam, tenbenh);
//	}
	
	public void save(Benh benh) {
		benhRepo.save(benh);
	}
	
	public Benh get(String id) {
		return benhRepo.findById(id).orElse(null);
	}
	
	public void delete(String id) {
		benhRepo.deleteById(id);
	}

	public List<Benh> getAllByIdIn(List<String> listBenhId) {
		return benhRepo.findAllById(listBenhId);
	}
}