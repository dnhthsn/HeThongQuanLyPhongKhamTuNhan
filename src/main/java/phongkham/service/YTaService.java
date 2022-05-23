package phongkham.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import phongkham.data.YTaRepository;
import phongkham.model.YTa;

@Service
@Transactional
public class YTaService {
	@Autowired
	private YTaRepository ytaRepo;
	
	public List<YTa> listAll(String keyword){
		if(keyword != null) {
			return ytaRepo.findAll(keyword);
		}
		return ytaRepo.findAll();
	}
	
	public List<YTa> listAllwithoutKeyword(){
		return ytaRepo.findAll();
	}
	
	public void save(YTa yta) {
		ytaRepo.save(yta);
	}
	
	public YTa get(int id) {
		return ytaRepo.findById((long) id).orElse(null);
	}
	
	public void delete(int id) {
		ytaRepo.deleteById((long) id);
	}

	public List<YTa> getAllByIdIn(List<Long> listYTaId) {
		return ytaRepo.findAllById(listYTaId);
	}
}