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

import lombok.Data;

@Data
@Entity
@Table(name = "hosokham_thuoc")
public class HoSoKham_Thuoc implements Serializable{
	private static final long serialVersionUID = 3L;
	@Id
	private int ho_so_kham_mahsk;
	
	@Id
	private String thuoc_tenthuoc;
}