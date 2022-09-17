package com.DijigoVneuron.Enterprise;

import com.DijigoVneuron.Enterprise.Repository.EnterpriseRepository;
import com.DijigoVneuron.Enterprise.model.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;


@SpringBootApplication
public class EnterpriseApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnterpriseApplication.class, args);

	}

}
