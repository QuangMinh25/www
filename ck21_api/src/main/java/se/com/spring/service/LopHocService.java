package se.com.spring.service;

import java.util.List;

import se.com.spring.entity.LopHoc;

public interface LopHocService {
	
	public List<LopHoc> getLopHocs();
	public LopHoc getLopHoc(int id);
	public void saveLopHoc(LopHoc lopHoc);
	public void deleteLopHoc(int id);

}
