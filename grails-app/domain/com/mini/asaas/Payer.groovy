package com.mini.asaas

import com.mini.asaas.base.BaseEntity
import com.mini.asaas.enums.TypeRegistry


class Payer extends BaseEntity {

    Customer customer
    TypeRegistry typeRegistry
    String name
    String email
    String cpfCnpj
    String postalCode
    String address
    String addressNumber

    static constraints = {
        name nullable: false, blank: false
        cpfCnpj nullable: false, blank: false
    }
}