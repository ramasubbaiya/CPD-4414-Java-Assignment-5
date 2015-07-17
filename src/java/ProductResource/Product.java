/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductResource;

/**
 *
 * @author c0652863
 */
public class Product {

    private int productId;
    private String name;
    int quantity;
    private String description;

    /**
     * Product Constructor
     */
    public Product() {
    }
    
    /**
     *
     * @param productId
     * @param name
     * @param description
     * @param quantity
     */
    public Product(int productId, String name,  String description, int quantity) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
    }

    /**
     *
     * @return productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     *
     * @param productId
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     *
     * @return getName
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return getQuantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return getDescription
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    

}
