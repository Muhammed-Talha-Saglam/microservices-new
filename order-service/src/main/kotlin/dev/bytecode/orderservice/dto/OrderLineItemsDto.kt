package dev.bytecode.orderservice.dto

import dev.bytecode.orderservice.model.OrderLineItems
import java.math.BigDecimal

data class OrderLineItemsDto(
    private val id: Long,
    private val skuCode: String,
    private val price: BigDecimal,
    private val quantity: Int
) {
    fun toOrderLineItems() = OrderLineItems(id, skuCode, price, quantity)
}
