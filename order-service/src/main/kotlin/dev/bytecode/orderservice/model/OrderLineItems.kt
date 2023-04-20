package dev.bytecode.orderservice.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "t_order_line_items")
data class OrderLineItems(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long,
    private val skuCode: String,
    private val price: BigDecimal,
    private val quantity: Int
)
