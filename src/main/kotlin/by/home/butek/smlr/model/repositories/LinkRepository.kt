package by.home.butek.smlr.model.repositories

import by.home.butek.smlr.model.Link
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LinkRepository : JpaRepository<Link, Long>