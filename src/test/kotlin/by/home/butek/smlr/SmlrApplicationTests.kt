package by.home.butek.smlr

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@TestPropertySource(locations = ["classpath:repositories-test.properties"])
@SpringBootTest
class SmlrApplicationTests {

	@Test
	fun contextLoads() {
	}

}
