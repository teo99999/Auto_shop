package com.informatics.cscb869f2020week7.data.repository;

import com.informatics.cscb869f2020week7.data.entity.Autoshop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AutoshopRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private AutoshopRepository autoshopRepository;

    @Test
    void findAllByNameTest(){

        String name = "AutoBG";

        Autoshop autoshop = new Autoshop();
        autoshop.setName(name);
        autoshop.setEmployeeCount(2);
        testEntityManager.persistAndFlush(autoshop);

        Autoshop autoshop1 = new Autoshop();
        autoshop1.setName(name);
        autoshop1.setEmployeeCount(2);
        testEntityManager.persistAndFlush(autoshop1);

        assertThat(autoshopRepository.findAllByName(name).size()).isEqualTo(2);
    }

}
