package by.home.butek.smlr.config

import by.home.butek.smlr.model.Link
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackageClasses = [Link::class])
class AppConfig