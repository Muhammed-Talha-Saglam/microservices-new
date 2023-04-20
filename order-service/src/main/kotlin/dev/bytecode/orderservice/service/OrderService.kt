package dev.bytecode.orderservice.service

import dev.bytecode.orderservice.dto.OrderRequest
import dev.bytecode.orderservice.model.Order
import dev.bytecode.orderservice.repository.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
@Transactional
class OrderService(
    private val orderRepository: OrderRepository
) {

    fun placeOrder(orderRequest: OrderRequest) {
        val orderLineItems = orderRequest.orderLineItemsDto.map { it.toOrderLineItems() }
        val order = Order(
            orderNumber = UUID.randomUUID().toString(),
            orderLineItemsList = orderLineItems
        )

        orderRepository.save(order)
    }
}