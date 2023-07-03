package objectDemo2;

public class SimpleTriangleObject2 extends SimpleGeometricObject 
implements Cloneable, Comparable<SimpleTriangleObject2>{
	private double base=1;
	private double height=1;
	private double side1=1;
	private double side2=1;
	
	public boolean equals(SimpleTriangleObject2 triangle) {
		return this.getArea() == triangle.getArea();
	}
	
	@Override
	public int compareTo(SimpleTriangleObject2 triangle) {
		if(this.getPerimeter() > triangle.getPerimeter())
			return 1;
		else if (this.getPerimeter() == triangle.getPerimeter())
			return 0;
		else
			return -1;
	}
	
	public SimpleTriangleObject2() {

	}
	
	public SimpleTriangleObject2(double base, double height, double side1, double side2) {
		this.base=base;
		this.height=height;
		this.side1=side1;
		this.side2=side2;
	}
	
	public SimpleTriangleObject2(double base, double height, double side1, double side2, String color, Boolean filled) {
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

