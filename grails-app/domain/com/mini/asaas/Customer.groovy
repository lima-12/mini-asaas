package com.mini.asaas
import com.mini.asaas.utils.BaseEntity

class Customer extends BaseEntity{
   String nome
   String email
   Integer cpfCnpj
   Integer cep
   String logradouro
   String numero 
   static constraints = {
        nome blank: false, maxSize: 255
        email email: true, blank: false, maxSize:255
        cpfCnpj blank: false, nullable: false, size:11..14 
        cep minSize: 8, maxSize: 8, blank: false, nullable: false
        logradouro blank: false, nullable: false, maxSize: 255
        numero blank: false, nullable: false, maxSize: 255
    }
   
}
