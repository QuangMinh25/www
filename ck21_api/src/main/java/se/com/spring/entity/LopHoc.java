package se.com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lophoc")
public class LopHoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "tenlophoc")
	private String tenLopHoc;
	@Column(name = "daynha")
	private String dayNha;
	@Column(name = "buoihoc")
	private String buoiHoc;
	
	public LopHoc() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenLopHoc() {
		return tenLopHoc;
	}

	public void setTenLopHoc(String tenLopHoc) {
		this.tenLopHoc = tenLopHoc;
	}

	public String getDayNha() {
		return dayNha;
	}

	public void setDayNha(String dayNha) {
		this.dayNha = dayNha;
	}

	public String getBuoiHoc() {
		return buoiHoc;
	}

	public void setBuoiHoc(String buoiHoc) {
		this.buoiHoc = buoiHoc;
	}

	@Override
	public String toString() {
		return "LopHoc [id=" + id + ", tenLopHoc=" + tenLopHoc + ", dayNha=" + dayNha + ", buoiHoc=" + buoiHoc + "]";
	}
	
	
	

}
