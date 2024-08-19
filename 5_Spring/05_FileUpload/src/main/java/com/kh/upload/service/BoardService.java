package com.kh.upload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;

import mapper.BoardMapper;



@Service
public class BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	public void addBoard(Board board) {
		 mapper.addBoard(board);
	}
	public List<Board> allview(Paging paging) {
		
		/*
		 * limit가 10인 경우
		 * page = n -> offset = (n-1)10;
		 * */
		paging.setOffset(paging.getLimit()*(paging.getPage()-1));
		
		 return mapper.allview(paging);
	}
	public void delete(int no) {
		 mapper.delete(no);
	}
	public void update(Board vo) {
		 mapper.update(vo);
	}
	public Board select(int no) {
		 return mapper.select(no);
	}
}
