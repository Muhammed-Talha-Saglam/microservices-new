package dev.bytecode.productservice.dto

import java.math.BigDecimal

data class ProductResponse(
    var id: String,
    var name: String,
    var description: String,
    var price: BigDecimal
)