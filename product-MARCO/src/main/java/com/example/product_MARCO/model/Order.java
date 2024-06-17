package com.example.product_MARCO.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")  // Renommer la table pour éviter le mot réservé
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommande;
    private int idClient;
    private LocalDateTime dateCommande;

    @ElementCollection
    private List<ProductInfo> productInfo;

    // Getters and Setters

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public List<ProductInfo> getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(List<ProductInfo> productInfo) {
        this.productInfo = productInfo;
    }
}

@Embeddable
class ProductInfo {
    private int idProduit;
    private Integer nombreProduit;

    // Getters and Setters

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public Integer getNombreProduit() {
        return nombreProduit;
    }

    public void setNombreProduit(Integer nombreProduit) {
        this.nombreProduit = nombreProduit;
    }
}
