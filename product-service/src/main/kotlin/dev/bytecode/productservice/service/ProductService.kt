package dev.bytecode.productservice.service

import dev.bytecode.productservice.dto.ProductRequest
import dev.bytecode.productservice.dto.ProductResponse
import dev.bytecode.productservice.model.Product
import dev.bytecode.productservice.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository
) {


    fun createProduct(productRequest: ProductRequest) {
        val product = Product(
            name = productRequest.name,
            description = productRequest.description,
            price = productRequest.price
            )

        productRepository.save(product)
        println("Product: $product")
    }

    fun getAllProducts(): List<ProductResponse> {
        val products = productRepository.findAll()
        return products.map { it.toProductResponse() }
    }

}