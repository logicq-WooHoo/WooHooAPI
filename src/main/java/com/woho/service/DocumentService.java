package com.woho.service;

import java.util.List;

import com.woho.model.Document;

public interface DocumentService {
	
	void saveDocument(Document document);
	Document getDocument(long id);
	List<Document> listAllDocuments();
	void deleteDocument(long id);
	void updateDocument(long id, Document document);
	public boolean isDocumentExist(Document document);
}
