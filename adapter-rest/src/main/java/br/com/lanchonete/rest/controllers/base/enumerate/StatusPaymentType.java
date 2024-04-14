package br.com.lanchonete.rest.controllers.base.enumerate;

import java.util.Arrays;

public enum StatusPaymentType {
    PENDING("Pendente"),
    REJECTED("Rejeitado"),
    PAID("Pago");

    private String description;

    StatusPaymentType(String description) {
        this.description = description;
    }

    public static StatusPaymentType get(String type) {
        return Arrays.stream(values()).filter(t -> t.name().equalsIgnoreCase(type)).findFirst().orElse(null);
    }

    public String getDescription() {
        return this.description;
    }

}
