// Justin Pope

public class TemperatureConversion {

	public static void main(String[] args) {
		System.out.println("Celsius\t\tFahrenheit\t|\tFarenheit\tCelsius");
		System.out.println("---------------------------------------------------------------");
		
		double celsius = 40; double fahrenheit = 120;
		for (int i = 1; i <= 10; celsius--, fahrenheit -= 10, i++) {
			System.out.printf("%.2f" + "\t\t" + "%.2f" + "\t\t|\t" + "%.2f" + "\t\t" + "%.2f"
			+ "\n",celsius,celsiusToFahrenheit(celsius),fahrenheit,fahrenheitToCelsius(fahrenheit));
		}
	}
	
	public static double celsiusToFahrenheit(double celsius) {
		return (9.0 / 5.0) * celsius + 32;
	}
	
	public static double fahrenheitToCelsius(double fahrenheit) {
		return (5.0 / 9) * (fahrenheit - 32);
	}
}
