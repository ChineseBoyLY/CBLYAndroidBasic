package com.example.junit.test;

import com.example.junit.service.CalcService;

import android.test.AndroidTestCase;

public class TestCalcService extends AndroidTestCase {
	/**
	 * ���쳣�׸����Կ��
	 * @throws Exception
	 */
	public void testAdd() throws Exception{
		CalcService service=new CalcService();
		int result = service.add(2, 4);
		assertEquals(8, result);
	}
}
