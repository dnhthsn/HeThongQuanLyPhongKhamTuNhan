package phongkham.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import phongkham.model.Thuoc;

public interface ThuocRepository extends JpaRepository<Thuoc, String>{

	@Query("SELECT t FROM Thuoc t WHERE t.tenthuoc LIKE %?1%")
	public List<Thuoc> findAll(String keyword);
	
	@Query("SELECT t FROM Thuoc t, HoSoKham_Thuoc ht WHERE ht.ho_so_kham_mahsk = ?1 AND t.tenthuoc = ht.thuoc_tenthuoc")
	public List<Thuoc> findUsedMedicine(Integer mahsk);
	
	@Query("SELECT t.giatien FROM Thuoc t WHERE t.tenthuoc LIKE %?1%")
	public float getGiaByName(String keyword);
}