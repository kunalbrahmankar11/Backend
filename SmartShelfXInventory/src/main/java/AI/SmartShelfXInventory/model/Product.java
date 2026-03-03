package AI.SmartShelfXInventory.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product{

    @Id
    private String id;
    private String sku;
    private String name;
    private String category;
    private String vendor;
    private int reorderLevel;
    private int currentStock;
    private int avgDailyDemand;
    private int leadTime;
    private int safetyStock;
    private int predictedDemand;

public Product(String id, String sku, String name, String category, int reorderLevel, String vendor, int currentStock, int avgDailyDemand, int leadTime, int safetyStock, int predictedDemand) {
    this.id = id;
    this.sku = sku;
    this.name = name;
    this.category = category;
    this.reorderLevel = reorderLevel;
    this.vendor = vendor;
    this.currentStock = currentStock;
    this.avgDailyDemand = avgDailyDemand;
    this.leadTime = leadTime;
    this.safetyStock = safetyStock;
    this.predictedDemand = predictedDemand;

}

    public Product() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public int getAvgDailyDemand() {
        return avgDailyDemand;
    }

    public void setAvgDailyDemand(int avgDailyDemand) {
        this.avgDailyDemand = avgDailyDemand;
    }

    public int getSafetyStock() {
        return safetyStock;
    }

    public void setSafetyStock(int safetyStock) {
        this.safetyStock = safetyStock;
    }

    public int getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(int leadTime) {
        this.leadTime = leadTime;
    }

    public int getPredictedDemand() {
        return predictedDemand;
    }

    public void setPredictedDemand(int predictedDemand) {
        this.predictedDemand = predictedDemand;
    }


// Getters and Setters

}
