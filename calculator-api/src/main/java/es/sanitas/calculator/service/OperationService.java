package es.sanitas.calculator.service;

import org.springframework.stereotype.Service;

import es.sanitas.calculator.model.Operation;

/**
 * Servicio para ejecución de operaciones aritméticas
 */
@Service
public class OperationService {

	/**
	 * Ejecuta una operación aritmética
	 * 
	 * @param operation La operación aritmética a ejecutar
	 * @return El valor resultado de la operación
	 */
	public Double executeOperation(Operation operation) {
		return operation.execute();
	}
	
}
