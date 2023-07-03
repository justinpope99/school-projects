// Justin Pope

package interfaceBasicDemo;

// Java program to demonstrate working of interface
   
// A class that implements the interface.
public class InterfaceTestDemo implements InterfaceDemo {
	
	// Implementing the capabilities of the interface.
	public void display(){
		System.out.println("Geek");
	}
	
	// Driver Code
	public static void main(String[] args)
	{
		InterfaceTestDemo t = new InterfaceTestDemo();
		t.display();
		System.out.println(a);
	}
}
