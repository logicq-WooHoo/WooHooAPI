package com.woho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DOCUMENT")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Size(max = 100)
	@Column(name = "FILE_NAME")
	private String filename;
	
	@Size(max = 100)
	@Column(name = "FILE_PATH")
	private String filePath;
	
	@Size(max = 100)
	@Column(name = "FILE_SIZE")
	private String fileSize;
	
	@Size(max = 100)
	@Column(name = "FILE_TYPE")
	private String fileType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", filename=" + filename + ", filePath=" + filePath + ", fileSize=" + fileSize
				+ ", fileType=" + fileType + "]";
	}
	
}
