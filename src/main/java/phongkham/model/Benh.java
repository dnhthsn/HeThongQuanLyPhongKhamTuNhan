package phongkham.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;


@Data
@Entity
@Table(name = "benh")
public class Benh implements Serializable {
	private static final long serialVersionUID = 2L;
	@Id
	@NotEmpty(message = "This field cannot be empty.")
	private String tenbenh;
	@NotEmpty(message = "This field cannot be empty.")
	private String mota;
	@NotEmpty(message = "This field cannot be empty.")
	private String loaibenh;
	
}
