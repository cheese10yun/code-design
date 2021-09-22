package com.code.design.object;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;

import org.junit.jupiter.api.Test;

class AddressTest {

    @Test
    public void Address_address1_비어있으면_exception() {
        thenThrownBy(() -> Address.builder()
            .address1("")
            .address2("address 2")
            .zip("zip")
            .build())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Address_address2_비어있으면_exception() {
        thenThrownBy(() -> Address.builder()
            .address1("address 1")
            .address2("")
            .zip("zip")
            .build())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Address_zip_비어있으면_exception() {
        thenThrownBy(() -> Address.builder()
            .address1("address 1")
            .address2("address 2")
            .zip("")
            .build())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Address_test() {
        final Address address = Address.builder()
            .address1("address 1")
            .address2("address 2")
            .zip("zip")
            .build();

        then(address.getAddress1()).isEqualTo("address 1");
        then(address.getAddress2()).isEqualTo("address 2");
        then(address.getZip()).isEqualTo("zip");
    }

}