package com.jpa.controller;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.domain.Movie;
import com.jpa.service.MovieService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/*")
@CrossOrigin(origins = {"*"}, maxAge=6000)
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	// 추가
	@PostMapping("/movie")
	public ResponseEntity add(@RequestBody Movie vo) {
		service.change(vo);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	// 조회
	@GetMapping("/movie")
	public ResponseEntity viewAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.viewAll());
	}
	
	// 단일조회
	@GetMapping("/movie/{id}")
	public ResponseEntity view(@PathVariable int id) {
		Movie movie = service.view(id);
		if(movie!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(service.view(id));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		 
	}
	
	// 수정
	@PutMapping("/movie")
	public ResponseEntity update(@RequestBody Movie vo) {
		service.change(vo);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	//삭제
	@DeleteMapping("/movie/{id}")
	public ResponseEntity update(@PathVariable int id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}








