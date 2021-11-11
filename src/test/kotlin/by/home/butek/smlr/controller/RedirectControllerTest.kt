package by.home.butek.smlr.controller

import by.home.butek.smlr.AbstractIntegrationTest
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import by.home.butek.smlr.controllers.RedirectController
import by.home.butek.smlr.service.KeyMapperService
import by.home.butek.smlr.whenever
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RedirectControllerTest: AbstractIntegrationTest() {

    @Autowired
    lateinit var webApplicationContext: WebApplicationContext

    lateinit var mockMvc: MockMvc

    @Mock
    lateinit var service: KeyMapperService

    @Autowired
    @InjectMocks
    lateinit var controller: RedirectController

    @BeforeEach
    fun init() {
        MockitoAnnotations.openMocks(this)
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
        whenever(service.getLink(PATH)).thenReturn(KeyMapperService.Get.Link(HEADER_VALUE))
        whenever(service.getLink(BAD_PATH)).thenReturn(KeyMapperService.Get.NotFound(BAD_PATH))
    }

    private val PATH = "aAbBcCdD"
    private val REDIRECT_STATUS: Int = 302
    private val HEADER_NAME ="Location"
    private val HEADER_VALUE ="http://www.eveonline.com"

    @Test
    fun controllerMustRedirectUsWhenRequestIsSuccessful() {
        mockMvc.perform(get("/$PATH"))
                .andExpect(status().`is`(REDIRECT_STATUS))
                .andExpect(header().string(HEADER_NAME, HEADER_VALUE))
    }

    private val BAD_PATH = "ololo"
    private val NOT_FOUND = 404

    @Test
    fun controllerMustReturn404ifBadKey() {
        mockMvc.perform(get("/$BAD_PATH"))
                .andExpect(status().`is`(NOT_FOUND))
    }

    @Test
    fun homeWorkFile() {
        mockMvc.perform(get("/"))
                .andExpect(view().name("home"))
    }

}