package com.wildcodeschool.quete1spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class Quete1springApplication {

	public static void main(String[] args) {
		SpringApplication.run(Quete1springApplication.class, args);
	}


	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "<ul><li><a href='http://localhost:8080/doctor/1'>Doctor 1</a></li><li><a href='http://localhost:8080/doctor/10'>Doctor 10</a></li><li><a href='http://localhost:8080/doctor/13'>Doctor 13</a></li><li><a href='http://localhost:8080/doctor/78958'>Doctor 78958</a></li></ul>";
	}

	@RequestMapping("/doctor/1")
	@ResponseBody
	public String doctor1() {
		return "William Hartnell";
	}

	@RequestMapping("/doctor/10")
	@ResponseBody
	public String doctor10() {
		return "David Tennant";
	}

	@RequestMapping("/doctor/13")
	@ResponseBody
	public String doctor13() {
		return "Jodie Whittaker";
	}

	@RequestMapping("/doctor/78958")
	@ResponseBody
	public String doctor78958() {
		return "Jenaija Maivulaseri";
	}

}
