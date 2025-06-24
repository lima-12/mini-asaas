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
       customer.cpfCnpj = params.cpfCnpj
       customer.postalCode = params.postalCode
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

    Customer getActiveCustomerById(Serializable id){
        Customer customer = Customer.get(id)
        if(customer && customer.deleted){
            return null
        }
        return customer
    }

    Customer update(Customer customer, Map params){
        
        Customer customerValidated = validateCustomerParams(params)
        
        if (customerValidated.hasErrors()) {
            throw new ValidationException("Erro ao salvar as alterações", customerValues.errors)
        }

        customer.name = params.name
        customer.email = params.email
        customer.cpfCnpj = params.cpfCnpj
        customer.postalCode = params.postalCode
        customer.adress = params.adress
        customer.adressNumber = params.adressNumber

        return customer.save(flush: true, failOnError: true)
    }

    List<Customer> list(Map args){
        return Customer.list(args)
    }

    List<Customer> listDeleted(Map args){
        return Customer.where {deleted == true}.list(args)
    }

    List<Customer> listActive(Map args){
        return Customer.where {deleted == false}.list(args)
    }

    Long count(){
        return Customer.count()
    }

    Long countActiveCustomers(){
        return Customer.countByDeleted(false)
    }

    void softDelete(Map params){
        Customer customer = Customer.get(params.id)
        if (customer.deleted){
            throw new IllegalArgumentException("Cliente com ID $customer.id já deletado")
        } 
        customer.deleted = true
        customer.save(flush: true, failOnError: true)
    }

    void delete(Map params){
        Customer customer = Customer.get(params.id)
        if (customer){
            customer.delete(flush: true, failOnError: true)
        } else{
            throw new IllegalArgumentException("Não encontrado")
        }
    }

}
