package by.home.butek.smlr.service

import by.home.butek.smlr.model.Link
import by.home.butek.smlr.model.repositories.LinkRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class DefaultKeyMapperService(
    private val converter: KeyConverterService,
    private val repo: LinkRepository
) : KeyMapperService {

    @Transactional
    override fun add(link: String) = converter.idToKey(repo.save(Link(link)).id)

    override fun getLink(key: String): KeyMapperService.Get {
        val result = repo.findById(converter.keyToId(key))
        return if (result.isPresent) {
            KeyMapperService.Get.Link(result.get().text)
        } else {
            KeyMapperService.Get.NotFound(key)
        }

    }
}