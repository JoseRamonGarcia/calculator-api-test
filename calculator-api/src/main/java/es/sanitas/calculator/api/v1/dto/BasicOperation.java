package es.sanitas.calculator.api.v1.dto;

/**
 * DTO de una operación aritmética básica
 */
public class BasicOperation {

	private double operand1;
	private double operand2;
	private Operator operator;
	
	public BasicOperation(Operator operator, double operand1, double operand2) {
		this.operator = operator;
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	
	public Operator getOperator() {
		return operator;
	}
	
	public double getOperand1() {
		return operand1;
	}
	
	public double getOperand2() {
		return operand2;
	}
	
}
