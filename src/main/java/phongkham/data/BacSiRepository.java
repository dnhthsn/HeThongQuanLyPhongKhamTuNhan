package phongkham.data;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import phongkham.model.BacSi;


public interface BacSiRepository extends JpaRepository<BacSi, Long> {
	
	@Query("SELECT bs FROM BacSi bs WHERE bs.tenbs LIKE %?1%")
	public List<BacSi> findAll(String keyword);
}
