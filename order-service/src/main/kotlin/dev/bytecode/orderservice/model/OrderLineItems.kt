package dev.bytecode.orderservice.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "t_order_line_items")
data class OrderLineItems(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val skuCode: String,
    val price: BigDecimal,
    val quantity: Int
)
