package se.com.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.com.spring.entity.LopHoc;
import se.com.spring.service.LopHocService;

@RestController
@RequestMapping("/api")
public class LopHocRestController {
	
	@Autowired
	private LopHocService lopHocService;
	
	@GetMapping("/lophocs")
	public List<LopHoc> getLopHocs(){
		return lopHocService.getLopHocs();
	}
	@GetMapping("/lophocs/{id}")
	public LopHoc getLopHoc(@PathVariable int id) {
		return lopHocService.getLopHoc(id);
		
	}
	@PostMapping("/lophocs")
	public LopHoc addLopHoc(@RequestBody LopHoc lopHoc) {
		lopHoc.setId(0);
		lopHocService.saveLopHoc(lopHoc);
		return lopHoc;
	}
	@PutMapping("/lophocs")
    public LopHoc updateLopHoc(@RequestBody LopHoc lopHoc) {
    	lopHocService.saveLopHoc(lopHoc);
		return lopHoc;
	}
	@DeleteMapping("/lophocs/{id}")
	public String deleteLopHoc(@PathVariable int id) {
		lopHocService.deleteLopHoc(id);
		return "id"+id;
	}

}
