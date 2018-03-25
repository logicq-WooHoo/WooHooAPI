package com.woho.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woho.dao.DocumentDao;
import com.woho.model.Document;
import com.woho.service.DocumentService;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	DocumentDao documentDao;

	@Override
	public void saveDocument(Document document) {
		documentDao.save(document);
	}

	@Override
	public Document getDocument(long id) {
		return documentDao.get(id);
	}

	@Override
	public List<Document> listAllDocuments() {
		return documentDao.list();
	}

	@Override
	public void deleteDocument(long id) {
		documentDao.delete(id);
	}

	@Override
	public void updateDocument(long id, Document document) {
		documentDao.update(id, document);
	}

	@Override
	public boolean isDocumentExist(Document document) {
		return documentDao.isDocumentExist(document);
	}
}