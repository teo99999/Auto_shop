package com.informatics.cscb869f2020week7.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.informatics.cscb869f2020week7.dto.CarDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "idClient")
@SecondaryTable(name = "Client")
public class Client extends User{

    private String name;

    @OneToMany(mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Car> cars;






}
