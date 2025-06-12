package com.mini.asaas

import com.mini.asaas.utils.BaseEntity


class Payer extends BaseEntity {

    String nome
    String cpfCnpj
    String cep
    String logradouro
    String numero

    static constraints = {
        nome nullable: false, blank: false
        cpfCnpj nullable: false, blank: false
        cep nullable: true
        logradouro nullable: true
        numero nullable: true
    }
}