package se.com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import se.com.spring.entity.LopHoc;

@Repository
public class LopHocDaoImpl implements LopHocDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<LopHoc> getLopHocs() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query<LopHoc> theQuery=session.createQuery("from LopHoc order by id",LopHoc.class);
		List<LopHoc> lopHocs=theQuery.getResultList();
		return lopHocs;
	}

	@Override
	public LopHoc getLopHoc(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		LopHoc lopHoc=session.get(LopHoc.class, id);
		return lopHoc;
	}

	@Override
	public void saveLopHoc(LopHoc lopHoc) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(lopHoc);
		
	}

	@Override
	public void deleteLopHoc(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query theQuery=session.createQuery("delete from LopHoc where id=:id");
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();

	}

}
