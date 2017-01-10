package tests;


	import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import api.Util;
import hw4.Counter;


	/**
	 * JUnit Tests designed to help with Hw4.
	 * @author Arnoldo Montoya-Gamez
	 *
	 */
	public class CounterTester {

		Counter cntr;
		
		@Before
		public void Initialize(){
			cntr = new Counter(3);
		}

		@Test
		public void CounterTest1() {
			String description = "Counter Test, outputs set to \"Initial_State\" - ";
			String expected = "000";
			String actual;
			actual = Util.toString(cntr.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void CounterTest2() {
			String description = "Run Counter's Tick() method once, with setEnabled(false) - ";
			String expected = "000";
			String actual;
			cntr.tick();
			actual = Util.toString(cntr.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void CounterTest3() {
			String description = "Run Counter's Tick() method once, with setEnabled(true) - ";
			String expected = "001";
			String actual;
			cntr.setEnabled(true);
			cntr.tick();
			actual = Util.toString(cntr.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void CounterTest4() {
			String description = "Run Counter's Tick() method twice, with setEnabled(true) - ";
			String expected = "010";
			String actual;
			cntr.setEnabled(true);
			for(int i = 0; i < 2; i++)
				cntr.tick();
			actual = Util.toString(cntr.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void CounterTest5() {
			String description = "Run Counter's Tick() method three times, with setEnabled(true) - ";
			String expected = "011";
			String actual;
			cntr.setEnabled(true);
			for(int i = 0; i < 3; i++)
				cntr.tick();
			actual = Util.toString(cntr.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void CounterTest6() {
			String description = "Run Counter's Tick() method four times, with setEnabled(true) - ";
			String expected = "100";
			String actual;
			cntr.setEnabled(true);
			for(int i = 0; i < 4; i++)
				cntr.tick();
			actual = Util.toString(cntr.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void CounterTest7() {
			String description = "Run Counter's clear() method, after running tick() method four times - ";
			String expected = "000";
			String actual;
			cntr.setEnabled(true);
			for(int i = 0; i < 4; i++)
				cntr.tick();
			cntr.clear();
			actual = Util.toString(cntr.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void CounterTest8() {
			String description = "Run Counter's Tick() method three times, with setEnabled(true), then setEnabled(false), then run counter's Tick() method three times - ";
			String expected = "011";
			String actual;
			cntr.setEnabled(true);
			for(int i = 0; i < 3; i++)
				cntr.tick();
			cntr.setEnabled(false);
			for(int j = 0; j < 5; j++)
				cntr.tick();
			actual = Util.toString(cntr.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void CounterTest9() {
			String description = "Run Counter's Tick() method eight times, with setEnabled(true) - ";
			String expected = "000";
			String actual;
			cntr.setEnabled(true);
			for(int i = 0; i < 8; i++)
				cntr.tick();
			actual = Util.toString(cntr.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void CounterTest10() {
			String description = "Run Counter's Tick() method eleven times, with setEnabled(true) - ";
			String expected = "011";
			String actual;
			cntr.setEnabled(true);
			for(int i = 0; i < 11; i++)
				cntr.tick();
			actual = Util.toString(cntr.outputs());
			assertEquals(description, expected, actual);
			}
		
		@Test
		public void CounterTest11() {
			String description = "Counter input() method Test, Run Counter's Tick() method eleven times, with setEnabled(true) - ";
			String expected = "[]";
			String actual;
			cntr.setEnabled(true);
			for(int i = 0; i < 11; i++)
				cntr.tick();		
			actual = Arrays.toString(cntr.inputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void CounterTest12() {
			String description = "Counter outputs() method Test, Run Counter's Tick() method eleven times, with setEnabled(true) - ";
			String expected = "[1, 1, 0]";
			String actual;
			cntr.setEnabled(true);
			for(int i = 0; i < 11; i++)
				cntr.tick();
			actual = Arrays.toString(cntr.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void CounterTest13() {
			String description = "Counter inputsValid() method Test, Run Counter's Tick() method eleven times, with setEnabled(true) - ";
			boolean expected = true;
			boolean actual;
			cntr.setEnabled(true);
			for(int i = 0; i < 11; i++)
				cntr.tick();
			actual = cntr.inputsValid();
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void CounterTest14() {
			String description = "Counter inputsValid() + invalidateinputs() method Test, Run Counter's Tick() method eleven times, with setEnabled(true) - ";
			boolean expected = true;
			boolean actual;
			cntr.setEnabled(true);
			for(int i = 0; i < 11; i++)
				cntr.tick();
			cntr.invalidateInputs();
			actual = cntr.inputsValid();
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void CounterTest15() {
			String description = "Counter outputsValid() method Test, Run Counter's Tick() method eleven times, with setEnabled(true) - ";
			boolean expected = true;
			boolean actual;
			cntr.setEnabled(true);
			for(int i = 0; i < 11; i++)
				cntr.tick();
			actual = cntr.outputsValid();
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void CounterTest16() {
			String description = "Counter outputsValid() + invalidateOutputs() method Test, Run Counter's Tick() method eleven times, with setEnabled(true) - ";
			boolean expected = true;
			boolean actual;
			cntr.setEnabled(true);
			for(int i = 0; i < 11; i++)
				cntr.tick();
			cntr.invalidateOutputs();
			actual = cntr.outputsValid();
			assertEquals(description, expected, actual);
		}

}