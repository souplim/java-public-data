package com.spring.injection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
	/* list */ 
//	private List<String> addressList;
//	
//	public void setAddressList(List<String> addressList) {
//		this.addressList = addressList;
//	}
//	public List<String> getAddressList(){
//		return addressList;
//	}
	
	/* set */
//	private Set<String> addressList;
//	public void setAddressList(Set<String> addressList) {
//		this.addressList = addressList;
//	}
//	public Set<String> getAddressList(){
//		return addressList;
//	}
	
	/* map */
//	private Map<String, String> addressList;
//	public void setAddressList(Map<String, String> addressList) {
//		this.addressList = addressList;
//	}
//	public Map<String, String> getAddressList(){
//		return addressList;
//	}
	
	/* properties */
	private Properties addressList;
	public void setAddressList(Properties addressList) {
		this.addressList = addressList;
	}
	public Properties getAddressList() {
		return addressList;
	}
}
