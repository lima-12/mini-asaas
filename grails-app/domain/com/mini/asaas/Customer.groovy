package com.mini.asaas
import com.mini.asaas.utils.BaseEntity

class Customer extends BaseEntity {
   String name
   String email
   Integer cpfCnpj
   Integer postalCode
   String adress
   String adressNumber 

   static constraints = {
        name blank: false
        email email: true, nullable: false
        cpfCnpj nullable: false
        postalCode nullable: false
        adress nullable: false
        adressNumber nullable: false
    }
   
}
