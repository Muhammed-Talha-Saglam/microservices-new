package dev.bytecode.inventoryservice.model

import jakarta.persistence.*

@Entity
@Table(name = "t_inventory")
data class Inventory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long = 0,
    private val skuCode: String,
    private val quantity: Int
)
