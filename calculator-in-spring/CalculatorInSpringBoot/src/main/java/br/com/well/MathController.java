package br.com.well;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.well.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo)throws Exception{
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please Set a numeric value ");
		
		}
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}
	
	@GetMapping("/multiply/{numberOne}/{numberTwo}")
	public Double multiply(@PathVariable(value = "numberOne")String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
			throws Exception{
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please Set a numeric value ");
		
		}
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}
	
	@GetMapping("/subtract/{numberOne}/{numberTwo}")
	public Double subtract (@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo)throws Exception{
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please Set a numeric value ");
		
		}
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
	}
	
	@GetMapping("/division/{numberOne}/{numberTwo}")
	public Double division (@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo)throws Exception{
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please Set a numeric value ");
		
		}
		if (convertToDouble(numberOne) == 0 || convertToDouble(numberTwo) == 0) {
			throw new UnsupportedMathOperationException("Please insert one number different from 0");
		}
		
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
	}
	
	@GetMapping("/average/{numberOne}/{numberTwo}")
	public Double division (@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo)throws Exception{
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please Set a numeric value ");
		
		}
		if (convertToDouble(numberOne) == 0 || convertToDouble(numberTwo) == 0) {
			throw new UnsupportedMathOperationException("Please insert one number different from 0");
		}
		
		return (convertToDouble(numberOne) + convertToDouble(numberTwo))/2 ;
	}
	
	
	
	private Double convertToDouble(String number) {
		if(number == null) return 0D;
		
		String num = number.replaceAll(",",".");
		if(isNumeric(num)) return Double.parseDouble(num);
		return 0D;
	}
	private boolean isNumeric (String number) {
		
		if(number == null) return false;
		String num = number.replaceAll(",",".");
		return num.matches("[-+]?[0-9]*\\.?[0-9]+");
		
	}
	
}
