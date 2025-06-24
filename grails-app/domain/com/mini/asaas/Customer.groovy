package com.mini.asaas
import com.mini.asaas.base.BaseEntity

class Customer extends BaseEntity {
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
