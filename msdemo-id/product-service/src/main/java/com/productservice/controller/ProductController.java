package com.productservice.controller;
import com.productservice.model.Product;
import com.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	@GetMapping
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + id));
	}
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	@GetMapping("/createsampleproduct")
	public Product createSampleProduct() {
		Product product = new Product("Sample Product", "This is a sample product", 199.99, 10);
		return productRepository.save(product);
	}
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
		Product product = productRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + id));
		product.setName(productDetails.getName());
		product.setDescription(productDetails.getDescription());
		product.setPrice(productDetails.getPrice());
		product.setQuantity(productDetails.getQuantity());
		return productRepository.save(product);
	}
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		Product product = productRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + id));
		productRepository.delete(product);
	}
}