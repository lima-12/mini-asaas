package com.mini.asaas

import grails.gorm.transactions.Transactional

@Transactional
class PayerService {

    List<Payer> list() {
        return Payer.list(sort: 'name', order: 'asc')
    }

    Payer get(Long id) {
        return Payer.get(id)
    }

    @Transactional
    Payer save(String name, String email, String cpfCnpj, String postalCode, String address, String addressNumber) {
        def payer = new Payer()
        payer.name = name
        payer.email = email
        payer.cpfCnpj = cpfCnpj
        payer.postalCode = postalCode
        payer.address = address
        payer.addressNumber = addressNumber

        return payer.save(flush: true)
    }

    @Transactional
    Payer update(Long id, String name, String email, String cpfCnpj, String postalCode, String address, String addressNumber) {
        Payer payer = Payer.get(id)

        if (payer) {
            payer.name = name
            payer.email = email
            payer.cpfCnpj = cpfCnpj
            payer.postalCode = postalCode
            payer.address = address
            payer.addressNumber = addressNumber

            payer.save(flush: true)
        }

        return payer
    }

    void delete(Long id) {
        Payer payer = Payer.get(id)
        if (payer) {
            payer.delete()
        }
    }
}