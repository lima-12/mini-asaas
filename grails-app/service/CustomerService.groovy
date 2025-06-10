package com.mini.asaas

import com.mini.asaas.Customer
import grails.gorm.transactions.Transactional

@Transactional
class CustomerService {
   public Customer save(String nome, String email, Integer cpfCnpj, Integer cep, String logradouro, String numero) {
       Customer customer = new Customer()
       customer.nome = nome
       customer.email = email
       customer.cpfCnpj = cpfCnpj
       customer.cep = cep
       customer.numero = numero
       customer.logradouro = logradouro
       //customer.save(failOnError: true)
       return customer
   }

   //validateParams ou use constrains
}
