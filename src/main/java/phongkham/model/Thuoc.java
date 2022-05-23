package phongkham.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "thuoc")
public class Thuoc implements Serializable{
	private static final long serialVersionUID = 2L;
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long mathuoc;
	@Id
	@NotEmpty(message = "This field cannot be empty.")
	private String tenthuoc;
	private float giatien;
	@NotEmpty(message = "This field cannot be empty.")
	private String loai;
	
//	@ManyToMany(targetEntity = HoSoKham.class)
//	private List<HoSoKham> thuoc = new ArrayList<>();
	
//	public static enum Type {
//		GIAMDAU, KHANGSINH, DIUNG
//	}
}