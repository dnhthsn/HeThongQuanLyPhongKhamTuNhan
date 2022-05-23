package phongkham.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
@Table(name = "benhnhan")
public class BenhNhan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mabn;
	@NotEmpty(message = "This field cannot be empty.")
	private String tenbn;
	@NotEmpty(message = "This field cannot be empty.")
	private String cmt;
	@NotEmpty(message = "This field cannot be empty.")
	@Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", message = "Must be formatted dd/mm/yyyy")
	private String ngaysinh;
	@NotEmpty(message = "This field cannot be empty.")
	private String diachi;
	@NotEmpty(message = "This field cannot be empty.")
	private String sdt;
}
