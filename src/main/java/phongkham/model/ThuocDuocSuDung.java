package phongkham.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ThuocDuocSuDung implements Serializable{
	private static final long serialVersionUID = 15L;
	
	private String tenthuoc;
	private String loai;
	private int solansudung;
}
