package dev.bytecode.inventoryservice

import dev.bytecode.inventoryservice.model.Inventory
import dev.bytecode.inventoryservice.repository.InventoryRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class InventoryServiceApplication {
}

fun main(args: Array<String>) {
	runApplication<InventoryServiceApplication>(*args)
}

@Component
class LoadData(private val inventoryRepository: InventoryRepository) : CommandLineRunner {
	override fun run(vararg args: String?) {
		val inventory = Inventory(skuCode = "iphone_13", quantity =  100)
		val inventory1 = Inventory(skuCode = "iphone_13_red", quantity =  0)
		inventoryRepository.saveAll(listOf(inventory, inventory1))
	}

}

