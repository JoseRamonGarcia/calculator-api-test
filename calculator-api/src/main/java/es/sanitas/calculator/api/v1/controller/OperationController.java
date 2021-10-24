package es.sanitas.calculator.api.v1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.sanitas.calculator.api.v1.dto.BasicOperation;
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
	public ResponseEntity<Double> calculate(@Valid @RequestBody BasicOperation operationDto) {
		Operation operation = operationMapper.getOperationFromDto(operationDto);
		Double value = operationService.executeOperation(operation);
		return ResponseEntity.ok(value);
	}
	
}
