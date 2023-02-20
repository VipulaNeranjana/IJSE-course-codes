package lk.ijse.dep10.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Item implements Serializable {
    private String code;
    private String description;
    private BigDecimal buyingPrice;
    private BigDecimal sellingPrice;
    private String Quantity;

    public Item(String code, String description, BigDecimal buyingPrice, BigDecimal sellingPrice, String quantity) {
        this.code = code;
        this.description = description;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.Quantity = quantity;
    }

    public Item() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBuyingPrice() {
        return buyingPrice.setScale(2);
    }

//    public BigDecimal getProfit(){
//        return sellingPrice.subtract(buyingPrice);
//    }

    public BigDecimal getTotal(){
        return buyingPrice.multiply(new BigDecimal(Quantity)).setScale(2);
    }

    public BigDecimal getEstimatedTotalPrice(){
        return sellingPrice.multiply(new BigDecimal(Quantity)).setScale(2);
    }
    public void setBuyingPrice(BigDecimal buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice.setScale(2);
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }
}
