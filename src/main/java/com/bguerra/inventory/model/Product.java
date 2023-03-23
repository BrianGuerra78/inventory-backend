package com.bguerra.inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = -7461389651533509262L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int price;

    private int account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Category category;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "picture")
    private byte[] picture;
}
