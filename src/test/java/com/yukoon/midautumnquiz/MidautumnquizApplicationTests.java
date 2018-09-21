package com.yukoon.midautumnquiz;

import com.yukoon.midautumnquiz.services.PuzzleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MidautumnquizApplicationTests {
	@Autowired
	private PuzzleService puzzleService;
	@Test
	public void contextLoads() {
		System.out.println(puzzleService.sortAll());
	}

}
