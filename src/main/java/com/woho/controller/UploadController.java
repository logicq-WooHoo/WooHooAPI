package com.woho.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.woho.model.Document;
import com.woho.service.DocumentService;
import com.woho.service.StorageService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class UploadController {

	@Autowired
	StorageService storageService;
	@Autowired
	DocumentService documentService;

	List<String> files = new ArrayList<String>();

	@Autowired
	ServletContext context;

	@PostMapping("/upload")
	public ResponseEntity<Document> uploadFile(@RequestParam("file") MultipartFile uploadfile) throws IOException {
		// String absolutePath =
		// context.getRealPath("resources/static/assets/video/");
		// String contextPath=context.getContextPath();
		// System.out.println(contextPath);
		Document document = new Document();
		byte[] bytes = uploadfile.getBytes();
		Path path = Paths
				.get("C://Users//SudhanshuLenka//Documents//GitHub//reckon//src//main//resources//static//assets//video//"
						+ uploadfile.getOriginalFilename());
		Files.write(path, bytes);
		document.setFilename(uploadfile.getOriginalFilename());
		document.setFileSize(uploadfile.getSize()); 
		String url = "http://127.0.0.1:8080/" + "assets/video/" + uploadfile.getOriginalFilename();
		document.setFilePath(url);
		document.setFileType(uploadfile.getContentType());
		documentService.saveDocument(document);
		return new ResponseEntity(document, HttpStatus.OK);

	}
	
	@GetMapping("/")
	public String listUploadedFiles(Model model) {
		return "uploadForm";
	}

	@PostMapping("/")
	public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
		try {
			storageService.store(file);
			model.addAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
			files.add(file.getOriginalFilename());
		} catch (Exception e) {
			model.addAttribute("message", "FAIL to upload " + file.getOriginalFilename() + "!");
		}
		return "uploadForm";
	}

	/*@GetMapping("/gellallfiles")
	public String getListFiles(Model model) {
		model.addAttribute("files",
				files.stream()
						.map(fileName -> MvcUriComponentsBuilder
								.fromMethodName(UploadController.class, "getFile", fileName).build().toString())
						.collect(Collectors.toList()));
		model.addAttribute("totalFiles", "TotalFiles: " + files.size());
		return "listFiles";
	}*/

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = storageService.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
}