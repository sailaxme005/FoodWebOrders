package com.epos.resources;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.epos.Base.BaseClass;



public class TestUtils extends BaseClass {
	public TestUtils() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static int IMPLICITY_WAIT = 10;
	public static int CAPTCHA_IMPLICITY_WAIT = 120;
}
