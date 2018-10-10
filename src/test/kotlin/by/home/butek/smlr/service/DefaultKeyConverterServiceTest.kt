package by.home.butek.smlr.service

import org.junit.Assert
import org.junit.Test
import java.util.*

class DefaultKeyConverterServiceTest {

    val service = DefaultKeyConverterService()

    @Test
    fun givenIdMustBeConvertableBothWays() {
        val rand = Random()
        for(i in 0..1000L) {
            val initialId = Math.abs(rand.nextLong())
            val key = service.idToKey(initialId)
            val id = service.keyToId(key)
            Assert.assertEquals(initialId, id)
        }
    }
}