package dev.bytecode.orderservice.dto


data class OrderRequest(
    val orderLineItemsDto: List<OrderLineItemsDto>
)
