package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ebook")
public class Ebook {

	
	@PostMapping(value = "/item")
	public ResponseEntity<?> post(@RequestBody String body){
		System.out.println(body);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "/item")
	public ResponseEntity<?> get(@RequestParam String ebookId, @RequestParam String pedidoId, @RequestParam String clienteId){
		System.out.println(ebookId + " " + pedidoId + " " + clienteId);
		return ResponseEntity.ok().build();
	}
}

