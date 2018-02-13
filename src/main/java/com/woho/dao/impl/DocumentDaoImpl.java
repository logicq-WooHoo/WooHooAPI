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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Document> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(long id, Document document) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDocumentExist(Document document) {
		// TODO Auto-generated method stub
		return false;
	}

	

	
}
