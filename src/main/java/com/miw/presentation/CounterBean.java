package com.miw.presentation;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.apache.log4j.Logger;

@ManagedBean(name = "counter", eager = true)
@ApplicationScoped
public class CounterBean {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	public CounterBean() {
		logger.debug("Initializing counter");
	}
	Integer count = 0 ;
	public Integer inc()
	{
		return ++ count;
	}
	public Integer getCount() {
		
		return count;
	}
}
