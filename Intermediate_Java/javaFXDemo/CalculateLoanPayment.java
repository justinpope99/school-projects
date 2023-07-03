package javaFXDemo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class Loan {
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	
	public Loan() {
		this(2.5, 1, 1000);
	}
	
	public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
	}
	
	public double getMonthlyPayment() {
		double monthlyInterestRate = annualInterestRate / 1200;
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
		return monthlyPayment;
	}
	
	public double getTotalPayment() {
		double totalPayment = getMonthlyPayment() * numberOfYears * 12;
		return totalPayment;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
}

public class CalculateLoanPayment extends Application {

	public static void main(String[] args) {

		  launch(args);

	}
	
	TextField tfLoan = new TextField();
	TextField tfYears = new TextField();
	TextArea taPayments = new TextArea();

	@Override
	public void start(Stage primaryStage) {

		Pane pane = new Pane();
		
		HBox hBox = new HBox(5);
		hBox.setAlignment(Pos.CENTER_LEFT);
		hBox.setPadding(new Insets(5, 5, 5, 5));
		hBox.getChildren().addAll(new Label("Loan Amount"), tfLoan, new Label("Number of Years"));
		tfYears.setPrefColumnCount(1);
		Button btTable = new Button("Show Table");
		btTable.setOnAction(e -> taPayments.setText(calculateLoanPayment()));
		hBox.getChildren().addAll(tfYears, btTable);
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(hBox, taPayments);
		
		pane.getChildren().add(vBox);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Project 9");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public String calculateLoanPayment() {
		Loan loan = new Loan();
		
		Double loanAmount = Double.parseDouble(tfLoan.getText());
		Integer numberOfYears = Integer.valueOf(tfYears.getText());
		
		loan.setNumberOfYears(numberOfYears);
		loan.setLoanAmount(loanAmount);

		String textField = "Interest Rate\t" + "Monthly Payment\t" + "Total Payment";
		String interest;
		String monthlyPayment;
		String totalPayment;
		
		for (double d = 5.0; d <= 8.0;) {
			loan.setAnnualInterestRate(d);
			interest = String.valueOf(d);
			monthlyPayment = String.format("%.2f", loan.getMonthlyPayment());
			totalPayment = String.format("%.2f", loan.getTotalPayment());
			String length = String.valueOf(d);
			d += 0.125;
			if (length.length() >= 5)
				textField += "\n" + interest + "\t\t" + monthlyPayment + "\t\t\t" + totalPayment;
			else
			textField += "\n" + interest + "\t\t\t" + monthlyPayment + "\t\t\t" + totalPayment; 
		}

		return textField;
		
	}

}
