package com.example.Shoppingverse.transformer;

import com.example.Shoppingverse.dto.request.CustomerRequestDto;
import com.example.Shoppingverse.dto.response.CustomerResponseDto;
import com.example.Shoppingverse.model.Customer;
import lombok.experimental.UtilityClass;

//@UtilityClass  // for ensuring class is not instantiated but not a std. practice to write
public class CustomerTransformer {

    public static Customer CustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){

        return Customer.builder()
                .name(customerRequestDto.getName())
                .gender(customerRequestDto.getGender())
                .mobNo(customerRequestDto.getMobNo())
                .emailId(customerRequestDto.getEmailId())
                .build();
    }

    public static CustomerResponseDto CustomerToCustomerResponseDto(Customer customer){

        return CustomerResponseDto.builder()
                .name(customer.getName())
                .gender(customer.getGender())
                .emailId(customer.getEmailId())
                .mobNo(customer.getMobNo())
                .build();
    }
}