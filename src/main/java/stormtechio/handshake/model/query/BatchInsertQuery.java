package stormtechio.handshake.model.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BatchInsertQuery {

	private String uid;
	private LinkedList<Query> batchOperation;
	private HashMap<String, List<Query>> tableMapping;
	
	public BatchInsertQuery() {
		this.tableMapping = new HashMap<>(4);
	}
	
	public void addQuery(String name) {
		
		Query query = new Query();
		query.setTableName(name);
		query.setColumns(new LinkedList<>());
		List<Query> queries;
		if(this.tableMapping.containsKey(name))
			queries = this.tableMapping.get(name);
		else 
			queries = new ArrayList<Query>();
		
		queries.add(query);
		this.tableMapping.put(name, queries);
	}
	
	public void addColumns(String tableName, LinkedList<String> columns ,int queryIndex) throws Exception {
		
		List<Query> queries = getQueries(tableName);
		
		if(queryIndex > queries.size() - 1) {
			throw new Exception("The requested query does not exist. Please, verify the existance of this query");
		}
		
		queries.get(queryIndex).setColumns(columns);
	}
	
	public List<Query> getQueries(String name) {
		return this.tableMapping.get(name);
	}
	
	public LinkedList<Query> getBatchOperation(){
		
		this.batchOperation = new LinkedList<Query>();
		Iterator<String> tableNames = this.tableMapping.keySet().iterator();
		
		while(tableNames.hasNext()) {
			String name = tableNames.next();
			List<Query> queries = (ArrayList<Query>) this.tableMapping.get(name);
			
			for(Query query : queries) {
				this.batchOperation.add(query);
			}
		}
		
		return this.batchOperation;
	}
	
	
}
