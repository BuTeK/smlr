package by.home.butek.smlr.model.repository

import by.home.butek.smlr.model.AbstractRepositoryTest
import by.home.butek.smlr.model.Link
import by.home.butek.smlr.model.repositories.LinkRepository
import com.github.springtestdbunit.annotation.DatabaseOperation
import com.github.springtestdbunit.annotation.DatabaseSetup
import com.github.springtestdbunit.annotation.DatabaseTearDown
import org.hamcrest.Matchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import java.util.*


@DatabaseSetup(LinkRepositoryTest.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = LinkRepositoryTest.DATASET)
open class LinkRepositoryTest : AbstractRepositoryTest() {

    @Autowired
    lateinit var repository: LinkRepository

    @Test
    fun findExisting() {
        val got: Optional<Link> = repository.findOne(LINK_1_ID)
        assertThat(got.isPresent, equalTo(true))
        val link = got.get()
        assertThat(link, equalTo(Link(LINK_1_TEXT, LINK_1_ID)))
    }

    @Test
    fun findOneNotExisting() {
        val got: Optional<Link> = repository.findOne(LINK_NOT_FOUND)
        assertThat(got.isPresent, equalTo(false))
    }

    @Test
    fun saveNew() {
        val toBeSaved: Link = Link(LINK_TBS_TEXT)
        val got: Link = repository.save(toBeSaved)
        val list: List<Link> = repository.findAll()
        assertThat(list, hasSize(4))
        assertThat(got.text, equalTo(LINK_TBS_TEXT))
    }

    companion object {

        const val DATASET = "classpath:datasets/link-table.xml"

        private val LINK_NOT_FOUND: Long = 1L
        private val LINK_1_ID: Long = 100500L
        private val LINK_1_TEXT: String = "http://www.eveonline.com"
        private val LINK_TBS_TEXT: String = "http://wow.ru"
    }

}
