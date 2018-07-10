package org.laidu.learn.swagger.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@Slf4j
@RunWith(SpringRunner.class)
//@SpringBootTest
public class SwaggerApplicationTests {

	@Test
	public void contextLoads() {

		Optional.ofNullable(null).map(String::valueOf).orElse("");
	}

}
