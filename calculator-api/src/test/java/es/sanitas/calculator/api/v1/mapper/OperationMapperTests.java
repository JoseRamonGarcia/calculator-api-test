package es.sanitas.calculator.api.v1.mapper;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import es.sanitas.calculator.api.v1.dto.BasicOperation;
import es.sanitas.calculator.api.v1.dto.Operator;
import es.sanitas.calculator.model.Addition;
import es.sanitas.calculator.model.Operation;
import es.sanitas.calculator.model.Subtraction;

public class OperationMapperTests {
	
	@Test
	public void whenGetOperationFromDtoWithAnAddOperationItShouldReturnAnAddition() {
		// Arrange
		OperationMapper operationMapper = new OperationMapper();
		BasicOperation basicOperation = new BasicOperation(Operator.ADD, 1, 2);
		
		// Act
		Operation operation = operationMapper.getOperationFromDto(basicOperation);
		
		// Assert
		assertTrue(operation instanceof Addition);
	}
	
	@Test
	public void whenGetOperationFromDtoWithAnSubtractOperationItShouldReturnAnSubtraction() {
		// Arrange
		OperationMapper operationMapper = new OperationMapper();
		BasicOperation basicOperation = new BasicOperation(Operator.SUBTRACT, 1, 2);
		
		// Act
		Operation operation = operationMapper.getOperationFromDto(basicOperation);
		
		// Assert
		assertTrue(operation instanceof Subtraction);
	}

}
