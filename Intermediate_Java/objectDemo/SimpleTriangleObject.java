package objectDemo;

public class SimpleTriangleObject extends SimpleGeometricObject {
	private double base;
	private double height;
	private double side1;
	private double side2;
	
	public SimpleTriangleObject() {
		base=1;
		height=1;
		side1=1;
		side2=1;
	}
	
	public SimpleTriangleObject(double base, double height, double side1, double side2) {
		this.base=base;
		this.height=height;
		this.side1=side1;
		this.side2=side2;
	}
	
	public SimpleTriangleObject(double base, double height, double side1, double side2, String color, Boolean filled) {
		this.base=base;
		this.height=height;
		this.side1=side1;
		this.side2=side2;
		setColor(color);
		setFilled(filled);
	}
	
	public void setBase(double base) {
		this.base=base;
	}
	
	public void setHeight(double height) {
		this.height=height;
	}
	
	public void setSide1(double side1) {
		this.side1=side1;
	}
	
	public void setSide2(double side2) {
		this.side2=side2;
	}
	
	public double getBase() {
		return base;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getSide1() {
		return side1;
	}
	
	public double getSide2() {
		return side2;
	}
	
	public double getArea() {
		return side1 + base + side2;
	}
	
	public double getPerimeter() {
		return 0.5 * (base * height);
	}
	
	public String toString() {
		return "created on " + getDateCreated() + "\ncolor: " + getColor() + 
		  " and filled: " + isFilled() +"\nbase is: " + getBase() + ", area is: " + getArea() + ", and perimeter is: " + getPerimeter();
	}
}

