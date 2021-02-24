package com.orion282.calculatorhazelcast;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/** Calculator logic*/
@Service
public class CalculatorHazelcast {
	@Cacheable("sum")
	public int sum(int a, int b) {
		try {
			Thread.sleep(10000);
		}
		catch (InterruptedException e) {
			System.out.println("Cache failed...");
			e.printStackTrace();
		}

		return a + b;
	}
}
