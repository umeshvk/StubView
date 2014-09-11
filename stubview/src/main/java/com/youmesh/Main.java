package com.youmesh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Main {
	private final static Logger LOG = Logger.getLogger(Main.class.getName());
	int transactionCount = 1; 
	Map<String, String> varMap = new HashMap<String, String>();
	Map<Integer, List<Command>> transactionMap = new  HashMap<Integer, List<Command>>();
	List<Integer> transactionList = new ArrayList<Integer>();
	
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.setValue("x", "10");
		LOG.info("x=" + main.getValue("x"));
		LOG.info("a=" + main.getValue("a"));
		main.beginTransaction();
		main.setValue("a", "5");
		main.setValue("b", "6");
		main.beginTransaction();
		main.setValue("a", "20");
		main.rollbackTransaction();
		main.setValue("a", "15");
		main.commitTransaction();
		LOG.info("a=" + main.getValue("a"));
		main.end();
	}
	
	private void end() {
		transactionCount = 1; 
		varMap = new HashMap<String, String>();
		transactionMap = new  HashMap<Integer, List<Command>>();
		transactionList = new ArrayList<Integer>();
	}

	private void beginTransaction() { 
		int transactionId = transactionCount++;
		transactionList.add(transactionId);
		Integer lastTransaction = getTopTransaction();
		if(lastTransaction != null) { 
			transactionMap.put(transactionId, new ArrayList<Command>());
		}
	}
	
	private Integer removeTopTransaction() { 
		if(transactionList.isEmpty()) { 
			return null;
		}
		return transactionList.remove(transactionList.size()-1);
	}
	
	private Integer getTopTransaction() { 
		if(transactionList.isEmpty()) { 
			return null;
		}
		return transactionList.get(transactionList.size()-1);
	}
	
	private void setValue(String name, String value) { 
		if(transactionList.isEmpty()) { 
			varMap.put(name, value);
			return; 
		}
		Integer lastTransaction = getTopTransaction();
		Command command = new Command(lastTransaction, name, value);
		transactionMap.get(lastTransaction).add(command);
	}
	
	private String getValue(String name) { 
		return varMap.get(name);
	}
	
	
	private void commitTransaction() { 
		if(transactionList.isEmpty()) { 
			throw new RuntimeException("No Transaction in progress");
		}
		Integer lastTransaction = removeTopTransaction();
		List<Command> commandList = transactionMap.remove(lastTransaction);
		for(Command command: commandList) { 
			varMap.put(command.getName(), command.getValue());
		}
	}

	private void rollbackTransaction() { 
		if(transactionList.isEmpty()) { 
			throw new RuntimeException("No Transaction in progress");
		}
		Integer lastTransaction = removeTopTransaction();
		transactionMap.remove(lastTransaction);
	}
	

}
