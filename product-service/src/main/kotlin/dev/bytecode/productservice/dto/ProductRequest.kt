package dev.bytecode.productservice.dto

import java.math.BigDecimal

data class ProductRequest(
    var name: String,
    var description: String,
    var price: BigDecimal
)
