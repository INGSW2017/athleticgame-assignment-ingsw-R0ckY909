package it.unical.test;

import java.time.Instant;

import org.junit.Assert;
import org.junit.Test;

import it.unical.asde.AthleticGame;

public class AthleticGameBasicTest {
	
	@Test
	public void addArrivalTest() {
		AthleticGame athleticGame = new AthleticGame("100 meters");
		athleticGame.addArrival("Manuel", Instant.now().plusMillis(4000));
		Assert.assertEquals(1, athleticGame.getArrivals().size());
		// Assert.assertEquals(2, athleticGame.getArrivals().size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getParecipiantTimeTest() {
		AthleticGame athleticGame = new AthleticGame("50m meters");
		athleticGame.addArrival("Manuel", Instant.now().plusMillis(1000));
		athleticGame.addArrival("Antonio", Instant.now().plusMillis(3000));
		long time = athleticGame.getParecipiantTime("Salvatore");
		// long time = athleticGame.getParecipiantTime("Manuel");
		System.out.println(time);
	}

}
