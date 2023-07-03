package objectDemo;

public class ObjectDemo {

	public static void main(String[] args) {
		
		SimpleTriangleObject triangle=new SimpleTriangleObject(10, 20, 15, 15, "Blue", true);
		
		System.out.println("The details of the triangle are: \n" + triangle.toString());
	}

}

