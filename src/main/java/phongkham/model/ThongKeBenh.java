package phongkham.model;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;

@Data
public class ThongKeBenh implements Serializable{
	private static final long serialVersionUID = 10L;
	private String tenbenh;
	private String mota;
	private String loaibenh;
	private int solanmac;
	
}