package com.shivu.calculator.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivu.calculator.controller.response.PerformedResultResponse;
import com.shivu.calculator.dao.SubCalculatorDao;
import com.shivu.calculator.entity.Calculator;
import com.shivu.calculator.exception.CalculatorException;
import com.shivu.calculator.repository.CalculatorRepo;

@Service
public class SubCalculatorDaoImpl  implements SubCalculatorDao{

	@Autowired
	private CalculatorRepo calculatorRepo;
 
	@Override
	public PerformedResultResponse subvalue(Calculator calculator) throws CalculatorException {
calculator.setResult(calculator.getNumber1()-calculator.getNumber2());
		
		
		Calculator calc = calculatorRepo.save(calculator);
		if(Objects.isNull(calc))
			throw new CalculatorException("Failed to perform sub value operation");
		else
			return new PerformedResultResponse().getPerformedOperation(calc);
		 
	}


}
