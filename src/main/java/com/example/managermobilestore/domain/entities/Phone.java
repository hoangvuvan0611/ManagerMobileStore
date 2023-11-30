package com.example.managermobilestore.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "phones")
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Phone implements Runnable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_name", length = 50, unique = true)
    private String phoneName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private BigDecimal price;

    @CreationTimestamp
    @Column(name = "create_date")
    private Timestamp createDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Supplier supplier;

    @OneToMany(mappedBy = "phone", cascade = CascadeType.REMOVE)
    private Collection<BillDetail> bills;

    @OneToMany(mappedBy = "phone")
    private Collection<ReceiptDetail> receipts;

    @Override
    public void run() {

    }
}
