package by.home.butek.smlr.model.repositories

import by.home.butek.smlr.model.Link
import org.springframework.data.repository.Repository
import java.util.*

interface LinkRepository : Repository<Link, Long> {
    fun findOne(id: Long?): Optional<Link>
    fun save(link: Link): Link
    fun findAll(): List<Link>
}