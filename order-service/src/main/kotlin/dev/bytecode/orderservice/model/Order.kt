package dev.bytecode.orderservice.model

import jakarta.persistence.*

@Entity
@Table(name = "t_orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0 ,
    val orderNumber: String,
    @OneToMany(cascade = [CascadeType.ALL])
    val orderLineItemsList: List<OrderLineItems>
)
