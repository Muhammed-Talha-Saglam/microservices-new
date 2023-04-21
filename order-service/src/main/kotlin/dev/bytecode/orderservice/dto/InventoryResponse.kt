package dev.bytecode.orderservice.dto

data class InventoryResponse(
    val skuCode: String,
    val isInStock: Boolean
)
