package com.example.softwarearchitecture.repository;

import com.example.softwarearchitecture.dto.Address;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AddressRepositoryTest {

    @Autowired
    private AddressPepository addressPepository;

    @Test
    public void addAddressTest() {
        Address address = Address.builder()
                .detail("anhui")
                .userId(2)
                .build();

        addressPepository.save(address);
    }
}
