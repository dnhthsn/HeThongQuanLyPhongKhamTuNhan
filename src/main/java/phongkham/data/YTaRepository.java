package phongkham.data;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import phongkham.model.BacSi;
import phongkham.model.YTa;


public interface YTaRepository extends JpaRepository<YTa, Long> {
	@Query("SELECT yt FROM YTa yt WHERE yt.tenyt LIKE %?1%")
	public List<YTa> findAll(String keyword);	
}
