package com.Techforge.SpeechFormFilling.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Techforge.SpeechFormFilling.Entity.Formdata;
import com.Techforge.SpeechFormFilling.Repository.FormdataRepository;

@Service
public class FormdataService {
	
	@Autowired
	private FormdataRepository repo;
	
	public String savedata(Formdata data) {
		
		Formdata form = new Formdata();
		
		form.setEmail(data.getEmail()+"@gmail.com");
		form.setLocation(data.getLocation());
		form.setMobile(data.getMobile());
		form.setName(data.getName());
		
		repo.save(form);
		
		return "saved succesfully";
		
	}
	
	public Formdata showmydata(String mobile) {
		Formdata data = repo.findByMobile(mobile);
		return data;
	}
	
	public List<Formdata> alldata(){
		List<Formdata> datas = repo.findAll();
		return datas;
	}

}
