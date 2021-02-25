package com.orion282.calculatorhazelcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CalculatorHazelcastController {
	@Autowired
	private CalculatorHazelcast calculatorhazelcast;

	@RequestMapping("/sum")
	String sum(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
		return String.valueOf(calculatorhazelcast.sum(a, b));
	}
}
