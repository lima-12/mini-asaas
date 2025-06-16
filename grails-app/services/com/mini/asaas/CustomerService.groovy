package com.mini.asaas

import com.mini.asaas.Customer
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException

@Transactional
class CustomerService {
    
    public Customer save(Map params) {
    
        Customer customerValidated = validateCustomerParams(params)
        
        if (customerValidated.hasErrors()) {
            throw new ValidationException("Erro ao salvar sua conta", customerValues.errors)
        }
    
       Customer customer = new Customer() 
       customer.name = params.name
       customer.email = params.email
       customer.cpfCnpj = params.cpfCnpj as Integer
       customer.postalCode = params.postalCode as Integer
       customer.adress = params.adress
       customer.adressNumber = params.adressNumber

       return customer.save(flush: true, failOnError: true)
   }

   private Customer validateCustomerParams(Map params) {

        Customer customer = new Customer()
        if (!params.name) {
            customer.errors.reject("name", null, "name é obrigatório")
        }

        if (!params.cpfCnpj) {
            customer.errors.reject("CPF ou CNPJ", null, "Campo obrigatório")
        }

        return customer
    }

    Customer get(Serializable id){
        return Customer.get(id)
    }

    List<Customer> list(Map args){
        return Customer.list(args)
    }

    Long count(){
        return Customer.count()
    }

    void delete(Serializable id){
        Customer customer = Customer.get(id)
        if (customer){
            println("Tentativa de delete")
        } else{
            throw new IllegalArgumentException("Não encontrado")
        }
    }

}
