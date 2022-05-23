package phongkham.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class LuongBacSi implements Serializable {
	private static final long serialVersionUID = 12L;
	
	private Long mabs;
	private String tenbs;
	private float luong;
}
