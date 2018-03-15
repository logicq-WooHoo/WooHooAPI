package com.woho.vo;

/**
 * 
 * @author Pankaj Labade
 *
 */
public class AddressVO {
	
	private String city;
	private String area;
	private String type;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "AddressVO [city=" + city + ", area=" + area + ", type=" + type + "]";
	}
}
