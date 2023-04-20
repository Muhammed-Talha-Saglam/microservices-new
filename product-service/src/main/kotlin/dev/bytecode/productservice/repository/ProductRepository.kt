package dev.bytecode.productservice.repository

import dev.bytecode.productservice.model.Product
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository: MongoRepository<Product, String> {

}