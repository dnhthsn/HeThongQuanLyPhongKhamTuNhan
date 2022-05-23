package phongkham.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import phongkham.model.HoSoKham;



public interface HoSoKhamRepository extends JpaRepository<HoSoKham, Long> {
	@Query("SELECT hsk FROM HoSoKham hsk WHERE hsk.mabn = ?1")
	public List<HoSoKham> findAll(Integer keyword);
	
	@Query("SELECT hsk FROM HoSoKham hsk WHERE hsk.ngayvaovien LIKE %?1% OR hsk.ngayravien LIKE %?1%")
	public List<HoSoKham> findAllbyMonth(String keyword); //   07/2021
}
