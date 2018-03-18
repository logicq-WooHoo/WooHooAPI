package com.woho.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woho.model.Document;
import com.woho.service.DocumentService;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

	@Override
	public void saveDocument(Document document) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Document getDocument(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Document> listAllDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDocument(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDocument(long id, Document document) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDocumentExist(Document document) {
		// TODO Auto-generated method stub
		return false;
	}
	

}