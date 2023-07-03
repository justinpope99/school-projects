// Justin Pope

package carInsurancePolicy;

public class CreatePolicies2
{
	public static void main(String[] args)
	{
		// Creating the car insurance policies.
		CarInsurancePolicy2 first = new CarInsurancePolicy2(123);
		CarInsurancePolicy2 second = new CarInsurancePolicy2(456, 4);
		CarInsurancePolicy2 third = new CarInsurancePolicy2(789, 12, "Newcastle");
		
		// Displaying the car insurance policies.
		first.display();
		second.display();
		third.display();
	}
}
