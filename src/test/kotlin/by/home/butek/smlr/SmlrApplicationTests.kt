package by.home.butek.smlr

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

@RunWith(SpringJUnit4ClassRunner::class)
@TestPropertySource(locations = ["classpath:repositories-test.properties"])
@WebAppConfiguration
class SmlrApplicationTests {

	@Test
	fun contextLoads() {
	}

}
