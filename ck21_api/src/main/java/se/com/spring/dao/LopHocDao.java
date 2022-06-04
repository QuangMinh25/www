package se.com.spring.dao;

import java.util.List;

import se.com.spring.entity.LopHoc;

public interface LopHocDao {
	
	public List<LopHoc> getLopHocs();
	public LopHoc getLopHoc(int id);
	public void saveLopHoc(LopHoc lopHoc);
	public void deleteLopHoc(int id);

}
