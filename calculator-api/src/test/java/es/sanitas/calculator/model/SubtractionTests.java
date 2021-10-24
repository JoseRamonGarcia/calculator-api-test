package es.sanitas.calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SubtractionTests {

	@Test
	public void whenExecuteItShouldReturnTheAdditionResult() {
		// Arrange
		Subtraction subtraction = new Subtraction(3, 1);
		
		// Act
		Double result = subtraction.execute();
		
		// Assert
		assertEquals(2.0, result, 0);
	}

}
