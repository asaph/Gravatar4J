package org.asaph.gravatar;
/*
 * Copyright 2010 asaph.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author asaph
 *
 */
public class EncodingHelperTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.asaph.gravatar.EncodingHelper#hex(byte[])}.
	 */
	@Test
	public final void testHex() {
		assertEquals("096162636465666768696a6b6c6d6e6f707172737475767778797a09", EncodingHelper.hex("\tabcdefghijklmnopqrstuvwxyz\t".getBytes()));
	}

	/**
	 * Test method for {@link org.asaph.gravatar.EncodingHelper#md5Hex(java.lang.String)}.
	 */
	@Test
	public final void testMd5Hex() {
		assertEquals("5611b59184d00fe5e72f5e07367bb236", EncodingHelper.md5Hex("This is a test with \"spaces\", \"quotes\" & =/+-"));
	}

	/**
	 * Test method for {@link org.asaph.gravatar.EncodingHelper#urlEncode(java.lang.String)}.
	 */
	@Test
	public final void testUrlEncode() {
		assertEquals("This+is+a+test+with+%22spaces%22%2C+%22quotes%22+%26+%3D%2F%2B-", EncodingHelper.urlEncode("This is a test with \"spaces\", \"quotes\" & =/+-"));
	}

}
