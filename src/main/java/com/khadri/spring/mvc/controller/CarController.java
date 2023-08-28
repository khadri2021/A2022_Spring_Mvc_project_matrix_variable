package com.khadri.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class CarController {

	// order/cars/2;color=red
	@RequestMapping("/cars/{count}")
	@ResponseBody
	public String matrixColor(@PathVariable("count") Integer count, @MatrixVariable("color") String clr) {

		return count + " order success for color " + clr;
	}

	// order/bykes/2;color=red,blue
	@RequestMapping("/bykes/{count}")
	@ResponseBody
	public String matrixColors(@PathVariable("count") Integer count,
			@MatrixVariable MultiValueMap<String, String> multiValueMap) {

		return count + " order success   " + multiValueMap;
	}

	// order/cars/2;color=red,blue/bykes/2;color=green,yellow
	@RequestMapping("/cars/{carcount}/bykes/{bykecount}")
	@ResponseBody
	public String matrix(@PathVariable Integer carcount, @PathVariable Integer bykecount,
			@MatrixVariable MultiValueMap<String, String> multiValueMap) {

		return "car orders = " + carcount + " byke orders=" + bykecount + " all  " + multiValueMap;
	}

	// order/cars/order/number/2;color=red
	@RequestMapping("/cars/order/number/{carcount}")
	@ResponseBody
	public String matrixOptional(@PathVariable Integer carcount,
			@MatrixVariable(required = false, defaultValue = "blue") String color) {
		return "car orders = " + carcount + " color  " + color;
	}

}
