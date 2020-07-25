package stormtechio.handshake.model.query;

import java.util.LinkedList;

public class Query {
	
	private String tableName;
	private LinkedList<String> columns;
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public LinkedList<String> getColumns() {
		return columns;
	}
	public void setColumns(LinkedList<String> columns) {
		this.columns = columns;
	}
	
	
	
	
}
