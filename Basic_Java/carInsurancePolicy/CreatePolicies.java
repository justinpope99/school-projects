// Justin Pope

package carInsurancePolicy;

public class CreatePolicies
{
	public static void main(String[] args)
	{
		// Creating the car insurance policies.
		CarInsurancePolicy first = new CarInsurancePolicy(123);
		CarInsurancePolicy second = new CarInsurancePolicy(456, 4);
		CarInsurancePolicy third = new CarInsurancePolicy(789, 12, "Newcastle");
		
		// Displaying the car insurance policies.
		first.display();
		second.display();
		third.display();
	}
}
