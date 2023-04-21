package dev.bytecode.inventoryservice

import dev.bytecode.inventoryservice.dto.InventoryResponse
import dev.bytecode.inventoryservice.repository.InventoryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InventoryService(
    private val inventoryRepository: InventoryRepository
) {

    @Transactional(readOnly = true)
    fun isInStock(skuCode: List<String>): List<InventoryResponse> {
        return inventoryRepository.findBySkuCodeIn(skuCode).map {
            InventoryResponse(it.skuCode, it.quantity > 0)
        }
    }
}