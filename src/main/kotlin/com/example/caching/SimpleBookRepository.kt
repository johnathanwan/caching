package com.example.caching

import kotlinx.coroutines.*
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component

@Component
class SimpleBookRepository: BookRepository {

    @Cacheable("books")
    override fun getByIsbn(isbn: String): Book {
        simulateSlowService()
        return Book(isbn, "Some book")
    }

    private fun simulateSlowService() {
        runBlocking {
            delay(3000)
        }
    }
}