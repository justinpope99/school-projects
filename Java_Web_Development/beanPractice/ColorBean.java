package beanPractice;

public class ColorBean {
	
	private String foregroundColor = "black";
	private String backgroundColor = "white";
	
	public String getForegroundColor() {
		return foregroundColor;
	}
	
	public void setForegroundColor(String foregroundColor) {
		if (foregroundColor != null && !foregroundColor.trim().equals(""))
		this.foregroundColor = foregroundColor;
	}
	
	public String getBackgroundColor() {
		return backgroundColor;
	}
	
	public void setBackgroundColor(String backgroundColor) {
		if (backgroundColor != null && !backgroundColor.trim().equals(""))
		this.backgroundColor = backgroundColor;
	}
}
