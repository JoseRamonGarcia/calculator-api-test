package es.sanitas.calculator.api.v1.dto;

/**
 * Enumerado para identificar el tipo de operación a realizar
 */
public enum Operator {
	ADD ("+"),
	SUBTRACT ("-");

	private final String operatorLabel;

	Operator(String operatorLabel) {
		this.operatorLabel = operatorLabel;
	}
	
	public static Operator valueOfLabel(String label) {
		for (Operator operator : values()) {
	        if (operator.operatorLabel.equals(label)) {
	            return operator;
	        }
	    }
	    return null;
	}
	
}
