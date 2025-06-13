package com.mini.asaas

import com.mini.asaas.utils.BaseEntity


class Payer extends BaseEntity {

    String name
    String email
    String cpfCnpj
    String postalCode
    String adress
    String adressNumber

    static constraints = {
        name nullable: false, blank: false
        cpfCnpj nullable: false, blank: false
    }
}