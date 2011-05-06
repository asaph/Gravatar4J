/*
 * Copyright 2009 asaph.org
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

package org.asaph.gravatar;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * A JUnit4 test class for GravatarUrl
 * 
 * @author asaph
 */
public class GravatarUrlTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testWithEmailOnly() {
		GravatarUrl gravatarUrl = new GravatarUrl("iHaveAn@email.com");
		assertEquals("http://www.gravatar.com/avatar/3b3be63a4c2a439b013787725dfce802.jpg", gravatarUrl.toString());
	}

	@Test
	public final void testWithEmailAndSize() {
		GravatarUrl gravatarUrl = new GravatarUrl("iHaveAn@email.com");
		gravatarUrl.setSize(100);
		assertEquals("http://www.gravatar.com/avatar/3b3be63a4c2a439b013787725dfce802.jpg?s=100", gravatarUrl.toString());
	}	

	@Test
	public final void testWithEmailAndRating() {
		GravatarUrl gravatarUrl = new GravatarUrl("iHaveAn@email.com");
		gravatarUrl.setRating(GravatarUrl.Rating.PG);
		assertEquals("http://www.gravatar.com/avatar/3b3be63a4c2a439b013787725dfce802.jpg?r=pg", gravatarUrl.toString());
	}	

	@Test
	public final void testWithEmailAndDefaultIconConstant() {
		GravatarUrl gravatarUrl = new GravatarUrl("iHaveAn@email.com");
		gravatarUrl.setDefaultIcon(GravatarUrl.DEFAULT_ICON_IDENTICON);
		assertEquals("http://www.gravatar.com/avatar/3b3be63a4c2a439b013787725dfce802.jpg?d=identicon", gravatarUrl.toString());
	}	

	@Test
	public final void testWithEmailAndDefaultIconUrl() {
		GravatarUrl gravatarUrl = new GravatarUrl("iHaveAn@email.com");
		gravatarUrl.setDefaultIcon("http://example.com/images/example.jpg");
		assertEquals("http://www.gravatar.com/avatar/3b3be63a4c2a439b013787725dfce802.jpg?d=http%3A%2F%2Fexample.com%2Fimages%2Fexample.jpg", gravatarUrl.toString());
	}

	@Test
	public final void testWithAll() {
		GravatarUrl gravatarUrl = new GravatarUrl("iHaveAn@email.com", 512, GravatarUrl.Rating.PG, GravatarUrl.DEFAULT_ICON_IDENTICON);
		assertEquals("http://www.gravatar.com/avatar/3b3be63a4c2a439b013787725dfce802.jpg?s=512&r=pg&d=identicon", gravatarUrl.toString());
	}
}
