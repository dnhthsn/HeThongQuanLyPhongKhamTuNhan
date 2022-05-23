package phongkham.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;


@Data
@Entity
@Table(name = "hosokham")
public class HoSoKham {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mahsk;
	private String trangthai;
	private int mabs;
	@ManyToOne
	@JoinColumn(name = "mabs", insertable = false, updatable = false)
	private BacSi bacsi;

	private int mayt;
	@ManyToOne
	@JoinColumn(name = "mayt", insertable = false, updatable = false)
	private YTa yta;

	private int mabn;
	@ManyToOne
	@JoinColumn(name = "mabn", insertable = false, updatable = false)
	private BenhNhan benhnhan;
	
	@NotEmpty(message = "This field cannot be empty.")
	@Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", message = "Must be formatted dd/mm/yyyy")
	private String ngayvaovien;
	@NotEmpty(message = "This field cannot be empty.")
	@Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", message = "Must be formatted dd/mm/yyyy")
	private String ngayravien;
	
	
	private String tenbenh;
	@ManyToOne
	@JoinColumn(name = "tenbenh", insertable = false, updatable = false)
	private Benh benh;
	
	private float tonggiatien;
	private int malankham;
	@ManyToMany(targetEntity = Thuoc.class)
	private List<Thuoc> thuoc;

}