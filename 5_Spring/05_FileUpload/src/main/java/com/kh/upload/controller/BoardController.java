package com.kh.upload.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;
import com.kh.upload.service.BoardService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService bs;
	private int no;
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/write")
	public String write() {
		return "write";
	}
	@GetMapping("/list")
    public String list(Model model) {
         model.addAttribute("a", bs.allview(null));
        return "list"; 
    }
	@GetMapping("/view")
    public String view(Model model, int no) {
		this.no = no;
		model.addAttribute("a", bs.select(no));
        return "view"; 
    }
	@GetMapping("/delete")
    public String delete() {
		bs.delete(no);		
        return "list";
    }
	@PostMapping("/update")
    public String update(Board vo) throws Exception {
		fileupload(vo.getFile());
		Board bo = vo;
		bo.setNo(no);
		bs.update(bo);	 
        return "redirect:/list";
    }
	 
	public String fileupload(MultipartFile file) throws Exception {
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
		
		File copyFile = new File("\\\\192.168.10.51\\upload\\" + fileName);
		file.transferTo(copyFile);
		return copyFile.getAbsolutePath();
	}
	
	@PostMapping("/upload")
	public String upload(MultipartFile file) throws Exception {
		System.out.println("upload!");
		System.out.println("파일 이름 : " + file.getOriginalFilename());
		System.out.println("파일 사이즈 : " + file.getSize());
		System.out.println("파일 파라미터명 : " + file.getName());
		
		fileupload(file);
		
		
		return "redirect:/";
	}

	@PostMapping("/multiUpload")
	public String multiUpload(List<MultipartFile> files) throws Exception {
		
		for(MultipartFile file : files) {
			fileupload(file);
		}
		 	
		return "redirect:/";
	}
	@PostMapping("/write")
	public String write(Board board) throws Exception {
		board.setUrl(fileupload(board.getFile()));
		bs.addBoard(board);
		return "redirect:/";
	}
	
	@ResponseBody
	@GetMapping("/allview")
    public List<Board> allview(Paging paging) {
		List<Board> a = bs.allview(paging);
		return a; 
       
    }
	
}
