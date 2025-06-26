package com.mini.asaas
import com.mini.asaas.base.BaseEntity
import com.mini.asaas.enums.TypeRegistry

class Customer extends BaseEntity {

   TypeRegistry typeRegistry
   String name
   String email
   String cpfCnpj
   String postalCode
   String adress
   String adressNumber 

   static constraints = {
      name blank: false
      email email: true, blank: false
      cpfCnpj blank: false
      postalCode blank: false
      adress blank: false
      adressNumber blank: false
        //deleted display: false
   }
 
}
