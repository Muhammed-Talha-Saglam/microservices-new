package dev.bytecode.inventoryservice.controller

import dev.bytecode.inventoryservice.InventoryService
import dev.bytecode.inventoryservice.dto.InventoryResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/inventory")
class InventoryController(
    private val inventoryService: InventoryService
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun isInStocK(@RequestParam skuCode: List<String>): List<InventoryResponse> {
        return inventoryService.isInStock(skuCode)
    }

//    @GetMapping("/{sku-code}")
//    @ResponseStatus(HttpStatus.OK)
//    fun isInStocK(@PathVariable("sku-code") skuCode: String): Boolean {
//        return inventoryService.isInStock(skuCode)
//    }

}