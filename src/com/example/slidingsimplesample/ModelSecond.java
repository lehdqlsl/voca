package com.example.slidingsimplesample;

public class ModelSecond {

	private String name;
	private String place;
	private boolean selected;

	public ModelSecond(String name, String place) {
		this.name = name;
		this.place = place;
		selected = false;
	}

	public String getName() {
		return name;
	}

	public String getPlace() {
		return place;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}