package dev.bytecode.orderservice.service

import dev.bytecode.orderservice.dto.InventoryResponse
import dev.bytecode.orderservice.dto.OrderRequest
import dev.bytecode.orderservice.model.Order
import dev.bytecode.orderservice.repository.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import java.lang.IllegalArgumentException
import java.util.UUID

@Service
@Transactional
class OrderService(
    private val orderRepository: OrderRepository,
    private val webClient: WebClient
) {

    fun placeOrder(orderRequest: OrderRequest) {
        val orderLineItems = orderRequest.orderLineItemsDto.map { it.toOrderLineItems() }
        val order = Order(
            orderNumber = UUID.randomUUID().toString(),
            orderLineItemsList = orderLineItems
        )

        val skuCodes = order.orderLineItemsList.map { it.skuCode }

        // Call Inventory service, and place product if product is in stock
        // This is a synchronous request
        val inventoryResponse = webClient.get()
            .uri("http://localhost:8082/api/inventory/") { uriBuilder ->
                uriBuilder.queryParam("skuCode", skuCodes).build()
            }
            .retrieve()
            .bodyToMono<List<InventoryResponse>>()
            .block()

        val allProductsInStock = inventoryResponse?.all { it.isInStock }

        if (allProductsInStock == true) {
            orderRepository.save(order)
        } else {
            throw IllegalArgumentException("Product is not in stock. ")
        }
    }
}