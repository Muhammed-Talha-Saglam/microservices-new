package dev.bytecode.productservice

import com.fasterxml.jackson.databind.ObjectMapper
import dev.bytecode.productservice.dto.ProductRequest
import dev.bytecode.productservice.repository.ProductRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.junit.jupiter.Container
import java.math.BigDecimal

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	@Autowired
	private lateinit var mockMvc: MockMvc

	@Autowired
	private lateinit var objectMapper: ObjectMapper

	@Autowired
	private lateinit var productRepository: ProductRepository

	companion object {
		@Container
		var mongoDBContainer = MongoDBContainer("mongo:4.4.2")

		@DynamicPropertySource
		fun setProperties(dymDynamicPropertyRegistry: DynamicPropertyRegistry) {
			dymDynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl)
		}
	}

	@Test
	fun shouldCreateProduct() {
		val productRequest = getProductRequest()
		val productRequestString = objectMapper.writeValueAsString(productRequest)
		mockMvc.perform(
			MockMvcRequestBuilders.post("/api/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(productRequestString)
		)
			.andExpect(status().isCreated)

		Assertions.assertTrue(productRepository.findAll().size == 1)
	}

	private fun getProductRequest(): ProductRequest {
		return ProductRequest(
			name = "IPhone 14",
			description = "phone",
			price = BigDecimal(14000))
	}

}
