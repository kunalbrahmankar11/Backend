package AI.SmartShelfXInventory.service;

import AI.SmartShelfXInventory.model.Product;
import AI.SmartShelfXInventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Add new product
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // Update existing product
    private void checkAutoRestock(Product product) {

        int currentStock = product.getCurrentStock();
        int avgDailyDemand = product.getAvgDailyDemand();
        int leadTime = product.getLeadTime();
        int safetyStock = product.getSafetyStock();
        int predictedDemand = product.getPredictedDemand(); // from ML

        int reorderPoint = (avgDailyDemand * leadTime) + safetyStock;

        if (currentStock <= reorderPoint) {

            int orderQuantity = predictedDemand - currentStock;

            System.out.println("Auto Restock Triggered for: " + product.getName());
            System.out.println("Order Quantity: " + orderQuantity);

            // 👉 Here you can create Purchase Order
            // 👉 Or update stock
            // 👉 Or send notification
        }
    }
    public Product updateProduct(String id, Product updatedProduct) {

        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existing.setName(updatedProduct.getName());
        existing.setCurrentStock(updatedProduct.getCurrentStock());
        existing.setAvgDailyDemand(updatedProduct.getAvgDailyDemand());
        existing.setLeadTime(updatedProduct.getLeadTime());
        existing.setSafetyStock(updatedProduct.getSafetyStock());
        existing.setPredictedDemand(updatedProduct.getPredictedDemand());

        Product saved = productRepository.save(existing);

        // 🔥 Immediately check restock after update
        checkAutoRestock(saved);

        return saved;
    }

    // Delete product by ID
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    @Scheduled(cron = "0 0 2 * * ?") // Every day at 2 AM
    public void autoRestockCheck() {

        List<Product> products = productRepository.findAll();

        for(Product product : products) {
            checkAutoRestock(product);
        }
    }
}
