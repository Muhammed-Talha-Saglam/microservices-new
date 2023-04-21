package dev.bytecode.inventoryservice.model

import jakarta.persistence.*

@Entity
@Table(name = "t_inventory")
data class Inventory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    val skuCode: String,
    val quantity: Int
)
