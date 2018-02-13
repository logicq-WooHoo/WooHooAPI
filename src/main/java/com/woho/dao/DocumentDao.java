package com.woho.dao;

import java.util.List;

import com.woho.model.Document;

/**
 * 
 * @author Pankaj Labade
 *
 */
public interface DocumentDao {

	void save(Document document);
	Document get(long id);
	List<Document> list();
	void delete(long id);
	void update(long id, Document document);
	public boolean isDocumentExist(Document document);

}
