package es.sanitas.calculator.api.v1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.sanitas.calculator.api.v1.dto.BasicOperation;
import es.sanitas.calculator.api.v1.exceptions.MappingException;
import es.sanitas.calculator.api.v1.mapper.OperationMapper;
import es.sanitas.calculator.model.Operation;
import es.sanitas.calculator.service.OperationService;

/**
 * Controlador del api v1 para realizar operaciones aritméticas entre dos números
 */
@RestController
public class OperationController {

	private final OperationService operationService;
	private final OperationMapper operationMapper;

	@Autowired
	public OperationController(OperationMapper operationMapper, OperationService operationService) {
		this.operationMapper = operationMapper;
		this.operationService = operationService;
	}
	
	@PostMapping(value = "/v1/calculate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> calculate(@Valid @RequestBody BasicOperation operationDto) {
		Operation operation = null;
		try {
			operation = operationMapper.getOperationFromDto(operationDto);
		} catch (MappingException e) {
			//TODO: guardar log
			return ResponseEntity
		            .status(HttpStatus.NOT_IMPLEMENTED)
		            .body("Operador no válido: " + operationDto.getOperator().name());
		}
		Double value = operationService.executeOperation(operation);
		//TODO: guardar log
		return ResponseEntity.ok(value);
	}
	
	@ExceptionHandler({ HttpMessageNotReadableException.class })
    public ResponseEntity<?> handleException() {
		//TODO: guardar log
		return ResponseEntity
	            .status(HttpStatus.NOT_IMPLEMENTED)
	            .body("Operación no válida");
    }
	
}
