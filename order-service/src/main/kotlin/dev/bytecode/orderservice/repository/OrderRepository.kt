package dev.bytecode.orderservice.repository

import dev.bytecode.orderservice.model.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, Long> {
}