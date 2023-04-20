package dev.bytecode.inventoryservice.controller

import dev.bytecode.inventoryservice.InventoryService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/inventory")
class InventoryController(
    private val inventoryService: InventoryService
) {

    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    fun isInStocK(@PathVariable("sku-code") skuCode: String): Boolean {
        return inventoryService.isInStock(skuCode)
    }
}