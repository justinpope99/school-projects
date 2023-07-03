package objectDemo2;

public class ObjectDemo2 {

	public static void main(String[] args) {
		
		SimpleTriangleObject2 t1 = new SimpleTriangleObject2(10, 20, 15, 15, "Red", true);
		SimpleTriangleObject2 t2 = new SimpleTriangleObject2(10, 20, 15, 15, "White", false);
		System.out.println("The area of t1 is equal to the area of t2: " + t1.equals(t2));
		SimpleTriangleObject2 t3 = new SimpleTriangleObject2(25, 25, 35, 35, "Blue", true);
		SimpleTriangleObject2 t4 = new SimpleTriangleObject2(50, 50, 45, 45, "Black", true);
		System.out.println("\nGreater than = 1, Equal to = 0, Less than = -1\n"
		+ "The perimeter of t3 is greater than, equal to, or less than t4: " + t3.compareTo(t4));
		
	}

}
