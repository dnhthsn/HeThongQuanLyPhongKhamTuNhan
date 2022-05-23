package phongkham.model;

import java.io.Serializable;

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
@Table(name = "yta")
public class YTa implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mayt;
	@NotEmpty(message = "This field cannot be empty.")
	private String cmt;
	@NotEmpty(message = "This field cannot be empty.")
	private String tenyt;
	@NotEmpty(message = "This field cannot be empty.")
	private String trinhdo;
	@NotEmpty(message = "This field cannot be empty.")
	private String thamnien;
	@NotEmpty(message = "This field cannot be empty.")
	@Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", message = "Must be formatted dd/mm/yyyy")
	private String ngaysinh;
	@NotEmpty(message = "This field cannot be empty.")
	private String diachi;
	@NotEmpty(message = "This field cannot be empty.")
	private String sdt;	
}
