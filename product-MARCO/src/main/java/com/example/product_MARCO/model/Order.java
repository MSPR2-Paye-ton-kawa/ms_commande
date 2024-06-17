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
    private Long idCommande;
    private Long idClient;
    private LocalDateTime dateCommande;

    @ElementCollection
    private List<ProductInfo> productInfo;

    // Getters and Setters

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
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
    private Long idProduit;
    private Integer nombreProduit;

    // Getters and Setters

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public Integer getNombreProduit() {
        return nombreProduit;
    }

    public void setNombreProduit(Integer nombreProduit) {
        this.nombreProduit = nombreProduit;
    }
}
