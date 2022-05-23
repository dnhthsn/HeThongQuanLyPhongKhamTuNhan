package phongkham.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class LuongYta implements Serializable {
	private static final long serialVersionUID = 11L;
	
	private Long mayt;
	private String tenyt;
	private float luong;
}
