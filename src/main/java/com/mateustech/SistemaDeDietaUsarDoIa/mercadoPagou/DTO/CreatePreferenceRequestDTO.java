package com.mateustech.SistemaDeDietaUsarDoIa.mercadoPagou.DTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public record CreateReferenceRequestDTO (

    Long userid,

    @DecimalMin(value = "5.0", message = "Total amount must be positive")
    BigDecimal totalAmount,

    @NotNull
    PayerDTO payer,

    @NotNull
    BackUrlsDTO backUrls,

    @NotNull
    DeliveryAddressDTO deliveryAddress,

    @NotNull
    String autoReturn,

    @NotNull
    @Valid
    List<ItemDTO> items
) {
    public record PayerDTO (
        String name,
        String email
    ) {}

    public record BackUrlsDTO (
        String success,
        String failure,
        String pending
    ) {}

    public record DeliveryAddressDTO (
        String streetName,
        String streetNumber,
        String zipCode,
        String city,
        String state,
        String country,
        String neighborhood
    ) {}

    public record ItemDTO (
        String id,
        String title,
        Integer quantity,
        BigDecimal unitPrice
    ) {}
}
