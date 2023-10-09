package com.challenge.usercriticaldata.adapters.out.repository.entity;

import com.challenge.usercriticaldata.application.core.domain.Debt;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String cpf;
    private String name;
    private String address;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<DebtEntity> list;
}
