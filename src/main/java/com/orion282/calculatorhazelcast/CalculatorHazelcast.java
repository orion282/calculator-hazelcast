package com.orion282.calculatorhazelcast;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/** Calculator logic*/
@Service
public class CalculatorHazelcast {
	@Cacheable("sum")
	public int sum(int a, int b) {
		try {
			System.out.println("Try to get result from cache");
			Thread.sleep(3000);
		}
		catch (InterruptedException e) {
			System.out.println("Cache failed...");
			e.printStackTrace();
		}

		return a + b;
	}
}
