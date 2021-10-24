package es.sanitas.calculator.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import es.sanitas.calculator.model.Operation;

class OperationServiceTests {

	@Test
	public void whenExecuteOperationItShouldReturnTheOperationResult() {
		// Arrange
		OperationService operationService = new OperationService();
		Operation operation = Mockito.mock(Operation.class);
		Mockito.when(operation.execute()).thenReturn(5.0);
		
		// Act
		Double result = operationService.executeOperation(operation);
		
		// Assert
		assertEquals(5.0, result, 0);
	}

}
