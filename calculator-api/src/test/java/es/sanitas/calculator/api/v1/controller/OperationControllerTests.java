package es.sanitas.calculator.api.v1.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import es.sanitas.calculator.api.v1.dto.BasicOperation;
import es.sanitas.calculator.api.v1.dto.Operator;
import es.sanitas.calculator.api.v1.mapper.OperationMapper;
import es.sanitas.calculator.service.OperationService;

public class OperationControllerTests {
	
	@Test
	public void whenCalculateWithAnOperationItShouldMapTheDtoToModelAndReturnTheServiceOperationResult() {
		// Arrange
		OperationMapper operationMapper = Mockito.mock(OperationMapper.class);
		OperationService operationService = Mockito.mock(OperationService.class);
		Mockito.when(operationService.executeOperation(Mockito.any())).thenReturn(5.0);
		
		OperationController operationController = new OperationController(operationMapper, operationService);
		BasicOperation basicOperation = new BasicOperation(Operator.ADD, 1, 2);
		
		// Act
		ResponseEntity<Double> value = operationController.calculate(basicOperation);
		
		// Assert
		Mockito.verify(operationMapper).getOperationFromDto(basicOperation);
		assertEquals(5.0, value.getBody(), 0);
	}
	
}
