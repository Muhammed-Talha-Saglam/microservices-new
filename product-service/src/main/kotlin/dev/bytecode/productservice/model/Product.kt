package dev.bytecode.productservice.model

import dev.bytecode.productservice.dto.ProductResponse
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document(value = "product")
data class Product(
    @Id
    var id: String = "",
    var name: String,
    var description: String,
    var price: BigDecimal
) {
    fun toProductResponse() = ProductResponse(id, name, description, price)
}
