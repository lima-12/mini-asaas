package com.mini.asaas
import com.mini.asaas.base.BaseEntity

class Customer extends BaseEntity {
   String name
   String email
   String cpfCnpj
   String postalCode
   String adress
   String adressNumber 

   static hasMany = [customers: Customer]

   static constraints = {
      email email: true
        //deleted display: false
   }
 
}
