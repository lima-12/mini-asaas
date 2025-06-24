package com.mini.asaas

import com.mini.asaas.base.BaseEntity


class Payer extends BaseEntity {

    String name
    String email
    String cpfCnpj
    String postalCode
    String address
    String addressNumber

    static belongsTo = [customer: Customer]

    static constraints = {
        name nullable: false, blank: false
        cpfCnpj nullable: false, blank: false
    }
}