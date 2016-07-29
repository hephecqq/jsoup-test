package com.dagong.develop;

import java.io.IOException;

import org.junit.Test;

public class CountTest {

	@Test
	public void test() throws IOException {
		Count count = new Count();
		count.main(new String[]{"note.txt"});
	}
}
