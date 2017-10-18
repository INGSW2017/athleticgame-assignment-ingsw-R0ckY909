package it.unical.test;

import java.time.Instant;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.asde.AthleticGame;

public class AthleticGameWinnersTest {
	
	private static AthleticGame athleticGame;
	
	@BeforeClass
	public static void initialization() {
		athleticGame = new AthleticGame("100 meters");
	}
	
	@After
	public void afterReset() {
		athleticGame.reset();
	}
	
	@Before
	public void beforeStart() {
		athleticGame.start();
	}
	
	@Test
	public void getWinnerTest() {
		athleticGame.addArrival("Manuel", Instant.now().plusMillis(5000));
		athleticGame.addArrival("Salvatore", Instant.now().plusMillis(7500));
		athleticGame.addArrival("Antonio", Instant.now().plusMillis(10000));
		System.out.println("Manuel time: " + athleticGame.getParecipiantTime("Manuel") + " milliseconds");
		System.out.println("Salvatore time: " + athleticGame.getParecipiantTime("Salvatore") + " milliseconds");
		System.out.println("Antonio time: " + athleticGame.getParecipiantTime("Antonio") + " milliseconds");
		Assert.assertNotEquals("Salvatore isn't the winner", "Salvatore", athleticGame.getWinner());
		// Assert.assertNotEquals("Manuel isn't the winner", "Manuel", athleticGame.getWinner());
		Assert.assertEquals("Manuel", athleticGame.getWinner());
		// Assert.assertEquals("Salvatore", athleticGame.getWinner());
	}

}
