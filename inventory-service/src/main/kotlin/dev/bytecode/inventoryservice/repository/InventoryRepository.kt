package dev.bytecode.inventoryservice.repository

import dev.bytecode.inventoryservice.model.Inventory
import org.springframework.data.jpa.repository.JpaRepository

interface InventoryRepository: JpaRepository<Inventory, Long> {
    fun findSkuCode(): Inventory?
}