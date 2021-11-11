package com.dadaepo.emo;

import com.dadaepo.emo.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmoApplicationTests {

	@Test
	void dateTest() {
		System.out.println(DateUtil.getToday());
		System.out.println(DateUtil.getToday().plusDays(1));

	}

}
