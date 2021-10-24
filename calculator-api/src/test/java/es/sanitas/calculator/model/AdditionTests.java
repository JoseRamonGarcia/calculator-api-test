package es.sanitas.calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AdditionTests {

	@Test
	public void whenExecuteItShouldReturnTheAdditionResult() {
		// Arrange
		Addition addition = new Addition(1, 2);
		
		// Act
		Double result = addition.execute();
		
		// Assert
		assertEquals(3.0, result, 0);
	}

}
