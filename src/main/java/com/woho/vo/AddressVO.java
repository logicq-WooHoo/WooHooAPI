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
	private Double latitude;
	private Double longitude;

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

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "AddressVO [city=" + city + ", area=" + area + ", type=" + type + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}
}
