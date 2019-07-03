package com.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.MessageContext; 
import org.apache.synapse.mediators.AbstractMediator;

public class UpperCaseConvert extends AbstractMediator { 

	Log log=LogFactory.getLog(UpperCaseConvert.class);
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean mediate(MessageContext context) { 
		toUpper(context);
		return true;
	}
	
	private void toUpper(MessageContext context) {
		String city=(String) context.getProperty("CITY");
		log.debug("Values from sequence is "+city);
		
		String converted=city.toUpperCase();
		context.setProperty("CONVERTED", getName() + " is in "+converted);
	}
}
