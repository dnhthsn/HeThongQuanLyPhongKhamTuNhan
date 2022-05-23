package phongkham.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import phongkham.model.Benh;
import phongkham.model.ThongKeBenh;

public interface BenhRepository extends JpaRepository<Benh, String> {

	@Query("SELECT b FROM Benh b WHERE b.tenbenh LIKE %?1%")
	public List<Benh> findAll(String keyword);
	

}