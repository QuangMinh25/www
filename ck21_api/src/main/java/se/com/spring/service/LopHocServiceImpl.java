package se.com.spring.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import se.com.spring.dao.LopHocDao;
import se.com.spring.entity.LopHoc;

@Service
@Transactional
public class LopHocServiceImpl implements LopHocService{
	
	@Autowired
	private LopHocDao lopHocDao;

	@Override
	public List<LopHoc> getLopHocs() {
		// TODO Auto-generated method stub
		
		return lopHocDao.getLopHocs();
	}

	@Override
	public LopHoc getLopHoc(int id) {
		// TODO Auto-generated method stub
	
		return lopHocDao.getLopHoc(id);
	}

	@Override
	public void saveLopHoc(LopHoc lopHoc) {
		// TODO Auto-generated method stub
		lopHocDao.saveLopHoc(lopHoc);
		
	}

	@Override
	public void deleteLopHoc(int id) {
		// TODO Auto-generated method stub
		lopHocDao.deleteLopHoc(id);

	}

}
