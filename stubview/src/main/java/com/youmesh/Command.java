package com.youmesh;

public class Command {

	Integer transaction; 
	Integer parentTransaction; 
	String name; 
	String value; 
	
	public Command() {
		
	}

	public Command(Integer transaction, String name, String value) {
		this.transaction = transaction;
		this.name = name; 
		this.value = value; 
	}

	public Integer getTransaction() {
		return transaction;
	}

	public void setTransaction(Integer transaction) {
		this.transaction = transaction;
	}

	public Integer getParentTransaction() {
		return parentTransaction;
	}

	public void setParentTransaction(Integer parentTransaction) {
		this.parentTransaction = parentTransaction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
