package com.Techforge.SpeechFormFilling.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Techforge.SpeechFormFilling.Entity.Formdata;

public interface FormdataRepository extends JpaRepository<Formdata, Long> {
	
	Formdata findByMobile(String mobile);

}
