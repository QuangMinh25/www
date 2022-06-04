package se.com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import se.com.spring.model.LopHoc;
import se.com.spring.service.LopHocService;

@Controller
@RequestMapping("lophoc")
public class LopHocController {
	
	@Autowired
	private LopHocService lopHocService;
	
	@GetMapping("/list")
	public String list(Model model){
		List<LopHoc> lopHocs=lopHocService.getLopHocs();
		model.addAttribute("lophocs", lopHocs);
		return "list";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute LopHoc lopHoc) {
		 lopHocService.saveLopHoc(lopHoc);
		 return "redirect:/lophoc/list";
		
	}
	@GetMapping("/showadd")
	public String showadd(Model model) {
		LopHoc lopHoc=new LopHoc();
		model.addAttribute("lophoc", lopHoc);
		return "form";
	}
	@GetMapping("/showup")
	public String showup(Model model,@RequestParam("idlop") int id) {
		LopHoc lopHoc=lopHocService.getLopHoc(id);
		model.addAttribute("lophoc", lopHoc);
		return "form";
	}
	@GetMapping("/delete")
	public String deleteLopHoc(@RequestParam("id") int id) {
		lopHocService.deleteLopHoc(id);
		return "redirect:/lophoc/list";
	}

}
