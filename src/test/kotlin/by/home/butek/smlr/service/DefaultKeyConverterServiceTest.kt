package by.home.butek.smlr.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class DefaultKeyConverterServiceTest {

    private val service = DefaultKeyConverterService()

    @Test
    fun givenIdMustBeConvertableBothWays() {
        val rand = Random()
        for(i in 0..1000L) {
            val initialId = Math.abs(rand.nextLong())
            val key = service.idToKey(initialId)
            val id = service.keyToId(key)
            Assertions.assertEquals(initialId, id)
        }
    }
}