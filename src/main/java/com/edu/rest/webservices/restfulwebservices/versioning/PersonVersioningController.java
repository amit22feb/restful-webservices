package com.edu.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	//uri versioning - used by twitter
	@GetMapping("v1/person")
	public Personv1 personv1(){
		return new Personv1("Amit Kaushik");
	}
	
	@GetMapping("v2/person")
	public Personv2 personv2(){
		return new Personv2(new Name("Amit","Kaushik"));
	}
	
	//request param versioning - used by Amazon
	@GetMapping(value = "person/param", params="version=1")
	public Personv1 paramv1(){
		return new Personv1("Amit Kaushik");
	}
	
	@GetMapping(value = "person/param",params="version=2")
	public Personv2 param2(){
		return new Personv2(new Name("Amit","Kaushik"));
	}
	
	//custom header versioning - used by microsoft
	@GetMapping(value = "person/header", headers="X-API-VERSION=1")
	public Personv1 headerv1(){
		return new Personv1("Amit Kaushik");
	}
	
	@GetMapping(value = "person/header", headers="X-API-VERSION=2")
	public Personv2 headerv2(){
		return new Personv2(new Name("Amit","Kaushik"));
	}
	
	//mime type or accept versioning - used by Github
	
	@GetMapping(value = "person/produces", produces="application/vnd.company.app-v1+json")
	public Personv1 producesv1(){
		return new Personv1("Amit Kaushik");
	}
	
	@GetMapping(value = "person/produces", produces="application/vnd.company.app-v2+json")
	public Personv2 producesv2(){
		return new Personv2(new Name("Amit","Kaushik"));
	}
}
