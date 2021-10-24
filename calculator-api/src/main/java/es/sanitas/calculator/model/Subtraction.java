package es.sanitas.calculator.model;

/**
 * Clase que representa una operación aritmética de resta entre dos números
 */
public class Subtraction implements Operation {

	private final double operand1;
	private final double operand2;

	public Subtraction(double operand1, double operand2) {
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	
	@Override
	public Double execute() {
		return operand1 - operand2;
	}

}
