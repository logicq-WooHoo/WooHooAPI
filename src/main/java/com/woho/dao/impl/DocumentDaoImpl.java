package com.woho.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.DocumentDao;
import com.woho.model.Document;

/**
 * 
 * @author Pankaj Labade
 *
 */
@Repository
public class DocumentDaoImpl extends AbstractDAO<Document> implements DocumentDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5065502432824749955L;

	@Override
	public void save(Document document) {
		save(document);
	}
	
	@Override
	public Document get(long id) {
		return getRecordById(Document.class, id);
	}

	@Override
	public List<Document> list() {
		return (List<Document>) loadClass(Document.class);
	}

	@Override
	public void delete(long id) {
		delete(getRecordById(Document.class, id));
	}

	@Override
	public void update(long id, Document document) {
		document.setId(id);
		update(document);
	}

	@Override
	public boolean isDocumentExist(Document document) {
		return get(document.getId())!=null;
	}
	
}
