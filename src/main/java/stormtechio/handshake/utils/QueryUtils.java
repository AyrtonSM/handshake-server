package stormtechio.handshake.utils;

import java.util.LinkedList;
import java.util.Random;

import stormtechio.handshake.model.query.BatchInsertQuery;
import stormtechio.handshake.model.query.Query;

public class QueryUtils {
	
	public static String queryInsertBuilder(Query query) throws Exception {
		
		String tableName = query.getTableName().trim();
		
		if(tableName.contains(" ")) {
			throw new Exception("Query name ["+tableName+"] contains one or more spaces, please remove them in order to avoid SQLExceptions due to malformed query.");
		}
		
		StringBuilder queryBuilder = new StringBuilder("INSERT INTO ");
		queryBuilder.append(tableName + " ");
		queryBuilder.append("(");
		
		int pos = 0;
		for(String column : query.getColumns()) {
			
			if(pos != query.getColumns().size() - 1)
				queryBuilder.append(column + ", ");
			else
				queryBuilder.append(column);
			
			pos++;
			
		}
		
		queryBuilder.append(") ");
		queryBuilder.append("VALUES ");
		
		queryBuilder.append("(");
		
		pos = 0;
		for(int i = 0; i < query.getColumns().size(); i++) {
			if(pos != query.getColumns().size() - 1)
				queryBuilder.append("?, ");
			else
				queryBuilder.append("?");
			
			pos++;
		}
		
		queryBuilder.append(");");
		
		
		return queryBuilder.toString();
	}
	
	public static String batchQueryInsertBuilder(LinkedList<Query> queries) {
		StringBuilder queryBuilder = new StringBuilder("");
		
		for(Query query : queries) {
		
			try {
				String sql = queryInsertBuilder(query);
				queryBuilder.append(sql);
				queryBuilder.append("\n");
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}
		
		return queryBuilder.toString();
	}
	
//	public static void main(String[] args) {
//		
//		BatchInsertQuery batchOperation = new BatchInsertQuery();
//		
//		LinkedList<String> columns = new LinkedList<>();
//		columns.add("username");
//		columns.add("email");
//	
//		LinkedList<String> columns2 = new LinkedList<>();
//		columns2.add("user_id");
//		columns2.add("friends_since");
//		
//		
//		
//		batchOperation.addQuery("user");
//		
//		try {
//			batchOperation.addColumns("user", columns, 0);
//			
//		} catch (Exception e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		
//		batchOperation.addQuery("friends");
//		
//		
//		
//	
//		
//		try {
//			
//			batchOperation.addColumns("friends", columns2, 0);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		
//		String sql;
//		try {
//			sql = QueryUtils.batchQueryInsertBuilder(batchOperation.getBatchOperation());
//			
//			System.out.println(sql);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

}
