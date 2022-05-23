package phongkham.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import phongkham.model.BenhNhan;

public interface BenhNhanRepository extends JpaRepository<BenhNhan, Long> {
	@Query("SELECT bn FROM BenhNhan bn WHERE bn.tenbn LIKE %?1%")
	public List<BenhNhan> findAll(String keyword);
	
}
