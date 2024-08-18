package com.Techforge.SpeechFormFilling.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.Techforge.SpeechFormFilling.Dto.Frontend;
import com.Techforge.SpeechFormFilling.Entity.Formdata;
import com.Techforge.SpeechFormFilling.Service.FormdataService;

@RestController
public class FormController {
	
	@Autowired
	private FormdataService service;
	
	@PostMapping("/web/auth/savedata")
	public ResponseEntity<Frontend> savedata(@RequestBody Formdata data){
		
		Frontend front = new Frontend(service.savedata(data), true);
		
		return new ResponseEntity<Frontend>(front, HttpStatus.OK);
		
	}
	
	@GetMapping("/web/auth/showmydata")
	public ResponseEntity<Formdata> finddata(@RequestHeader String mobile){
		
		Formdata data = service.showmydata(mobile);
		
		return new ResponseEntity<Formdata>(data, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/admin/showalldata")
	public ResponseEntity<List<Formdata>> showalldata(){
		
		List<Formdata> datas = service.alldata();
		
		return new ResponseEntity<List<Formdata>>(datas, HttpStatus.OK);
		
	}

}
