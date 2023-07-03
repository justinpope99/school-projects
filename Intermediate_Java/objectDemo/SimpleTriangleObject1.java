package objectDemo;

public class SimpleTriangleObject1 extends SimpleGeometricObject {
	private double base = 1;
	private double height = 1;
	private double side1 = 1;
	private double side2 = 1;
	
	public SimpleTriangleObject1() {

	}
	
	public SimpleTriangleObject1(double base, double height, double side1, double side2) {
		this.base=base;
		this.height=height;
		this.side1=side1;
		this.side2=side2;
	}
	
	public SimpleTriangleObject1(double base, double height, double side1, double side2, String color, Boolean filled) {
		//super(color, filled);
		setColor(color);
		setFilled(filled);
		this.base=base;
		this.height=height;
		this.side1=side1;
		this.side2=side2;

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
		return base + side1 + side2;
	}
	
	public double getPerimeter() {
		return (base * height)/2;
	}
	
	public String toString() {
		return "created on " + getDateCreated() + "\ncolor: " + getColor() + 
		  " and filled: " + isFilled() +"\nbase is: " + getBase() + ", area is: " + getArea() + ", and perimeter is: " + getPerimeter();
	}
}

