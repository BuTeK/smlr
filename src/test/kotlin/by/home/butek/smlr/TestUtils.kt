package by.home.butek.smlr

import org.mockito.Mockito

fun <T> whenever(call: T) = Mockito.`when`(call)
inline fun <reified T : Any> mock() = Mockito.mock(T::class.java)