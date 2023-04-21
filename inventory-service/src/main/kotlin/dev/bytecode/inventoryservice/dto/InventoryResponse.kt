package dev.bytecode.inventoryservice.dto

data class InventoryResponse(
    private val skuCode: String,
    private val isInStock: Boolean
)
