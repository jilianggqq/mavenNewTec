package edu.gqq.fortest;

import java.text.DecimalFormat;

import org.junit.Before;
import org.junit.Test;

public class ChartTestTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testroundToNextSignificant() {
		float round1 = ChartTest.roundToNextSignificant(0);
		float round2 = ChartTest.roundToNextSignificant(2);
		float round3 = ChartTest.roundToNextSignificant(3);
		System.out.println(String.format("%f,%f,%f", round1, round2, round3));
	}

	@Test
	public void testgetDecimals() {
		int decimals = ChartTest.getDecimals(0f);
		System.out.println(String.format("%d", decimals));

		String calcFormats = ChartTest.calcFormats(3333.2385f);
		System.out.println(String.format("%s", calcFormats));

		// just test DecimalFormatter.
		DecimalFormat df = new DecimalFormat("###,###,###,###.000");
		System.out.println(df.format(579345.342534));

	}

}
