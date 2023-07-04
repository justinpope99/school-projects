package jspColorUtilityPractice;

public class ColorUtils {
	public static String randomColor() {
		 if (Math.random() < 0.1) {
			 return("BLUE");
		 } else if (Math.random() < 0.2){
			 return("RED");
		 } else if (Math.random() < 0.3){
			 return("YELLOW");
		 } else if (Math.random() < 0.4){
			 return("GREEN");
		 } else if (Math.random() < 0.5){
			 return("ORANGE");
		 } else if (Math.random() < 0.6){
			 return("PURPLE");
		 } else if (Math.random() < 0.7){
			 return("BLACK");
		 } else if (Math.random() < 0.8){
			 return("WHITE");
		 } else if (Math.random() < 0.8){
			 return("GRAY");
		 } else {
			 return("PINK");
		 }
	}
}
