package by.home.butek.smlr.model

import javax.persistence.*

@Entity
@Table(name = "links")
data class Link (
    var text: String = "",

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
)