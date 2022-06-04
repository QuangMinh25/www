package se.com.spring.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


import se.com.spring.model.LopHoc;

@Service
public class LopHocServiceImpl implements LopHocService{
	
	@Autowired
	private RestTemplate restTemplate;
	private String crm;
	
	public LopHocServiceImpl(RestTemplate theRestTemplate,@Value("${rs}") String theUrl) {
		// TODO Auto-generated constructor stub
		restTemplate=theRestTemplate;
		crm=theUrl;
	}

	@Override
	public List<LopHoc> getLopHocs() {
		// TODO Auto-generated method stub
		
		ResponseEntity<List<LopHoc>> responseEntity=restTemplate.exchange(crm, HttpMethod.GET,
				null,new ParameterizedTypeReference<List<LopHoc>>() {
				});
		List<LopHoc> lopHocs=responseEntity.getBody();
		return lopHocs;
	}

	@Override
	public LopHoc getLopHoc(int id) {
		// TODO Auto-generated method stub
	
		LopHoc lopHoc=restTemplate.getForObject(crm + "/" +id, LopHoc.class);
		return lopHoc;
	}

	@Override
	public void saveLopHoc(LopHoc lopHoc) {
		// TODO Auto-generated method stub
		int idlop=lopHoc.getId();
		if(idlop==0) {
			restTemplate.postForEntity(crm, lopHoc, String.class);
		}else {
			restTemplate.put(crm, lopHoc);
		}
		
	}

	@Override
	public void deleteLopHoc(int id) {
		// TODO Auto-generated method stub
		restTemplate.delete(crm + "/" +id);

	}

}
