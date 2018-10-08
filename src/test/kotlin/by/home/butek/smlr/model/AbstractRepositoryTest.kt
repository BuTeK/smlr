package by.home.butek.smlr.model

import by.home.butek.smlr.SmlrApplication
import com.github.springtestdbunit.DbUnitTestExecutionListener
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests

@TestExecutionListeners(DbUnitTestExecutionListener::class)
@ContextConfiguration(classes = [SmlrApplication::class])
@DirtiesContext
abstract class AbstractRepositoryTest : AbstractTransactionalJUnit4SpringContextTests() {
}