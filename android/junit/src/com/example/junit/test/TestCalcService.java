package com.example.junit.test;

import com.example.junit.service.CalcService;

import android.test.AndroidTestCase;

public class TestCalcService extends AndroidTestCase {
	/**
	 * °ÉÒì³£Å×¸ø²âÊÔ¿ò¼Ü
	 * @throws Exception
	 */
	public void testAdd() throws Exception{
		CalcService service=new CalcService();
		int result = service.add(2, 4);
		assertEquals(8, result);
	}
}
