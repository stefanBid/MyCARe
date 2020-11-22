package dao;

import java.sql.SQLException;
import java.util.Collection;

import model.ProductBean;
import model.RecensioniBean;

public interface RecensioniModel {
	
	public void doSave(RecensioniBean recensione) throws SQLException;
	
	public RecensioniBean doRetrieveFeedByProduct(ProductBean prodotto) throws SQLException;

	public Collection<RecensioniBean> doRetrieveAll(ProductBean prodotto) throws SQLException;
}
