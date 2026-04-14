package com.session08ex01.dto;

import jakarta.validation.constraints.NotBlank;

public class AddressDto {

    @NotBlank(message = "Tên người nhận không được thiếu hoặc để trống")
    private String receiverName;

    @NotBlank(message = "Địa chỉ không được thiếu hoặc để trống")
    private String detailedAddress;

    // getters, setters...
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }
}
