package es.sanitas.calculator.api.v1.mapper;

import org.springframework.stereotype.Component;

import es.sanitas.calculator.api.v1.dto.BasicOperation;
import es.sanitas.calculator.api.v1.exceptions.MappingException;
import es.sanitas.calculator.model.Addition;
import es.sanitas.calculator.model.Operation;
import es.sanitas.calculator.model.Subtraction;

/**
 * Clase mapper para generar objetos del modelo a partir de DTOs que provienen de las peticiones al api
 */
@Component
public class OperationMapper {

	public Operation getOperationFromDto(BasicOperation operationDto) throws MappingException {
		switch (operationDto.getOperator()) {
		case ADD:
			return new Addition(operationDto.getOperand1(), operationDto.getOperand2());
		case SUBTRACT:
			return new Subtraction(operationDto.getOperand1(), operationDto.getOperand2());
		default:
			throw new MappingException("Operador no válido: " + operationDto.getOperator());
		}
	}
}
