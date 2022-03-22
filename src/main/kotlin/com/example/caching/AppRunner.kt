package com.example.caching

import mu.*
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class AppRunner(val bookRepository: BookRepository) : CommandLineRunner {
    companion object {
        val logger = KotlinLogging.logger {}

    }

    override fun run(vararg args: String?) {
        logger.info { "... Fetching books" }
        logger.info { "isbn-1234 --> ${bookRepository.getByIsbn("isbn-1234")}" }
        logger.info { "isbn-4567 --> ${bookRepository.getByIsbn("isbn-4567")}" }
        logger.info { "isbn-1234 --> ${bookRepository.getByIsbn("isbn-1234")}" }
        logger.info { "isbn-4567 --> ${bookRepository.getByIsbn("isbn-4567")}" }
        logger.info { "isbn-1234 --> ${bookRepository.getByIsbn("isbn-1234")}" }
        logger.info { "isbn-1234 --> ${bookRepository.getByIsbn("isbn-1234")}" }
    }
}