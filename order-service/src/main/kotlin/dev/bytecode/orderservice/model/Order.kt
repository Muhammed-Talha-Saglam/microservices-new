package dev.bytecode.orderservice.model

import jakarta.persistence.*

@Entity
@Table(name = "t_orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private var id: Long = 0 ,
    private val orderNumber: String,
    @OneToMany(cascade = [CascadeType.ALL])
    private val orderLineItemsList: List<OrderLineItems>
)
