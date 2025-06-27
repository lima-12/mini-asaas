package com.mini.asaas

import com.mini.asaas.base.BaseEntity

class Payment extends BaseEntity {

    Customer customer
    Payer payer
    BigDecimal value
    String billingType
    String status
    Date dueDate

    static constraints = {
        payer nullable: false
        value nullable: false
        billingType inList: [
                'BOLETO',
                'PIX',
                'DEBIT_CARD',
        ]
        status inList: [
                'OVERDUE',
                'PENDING',
                'RECEIVED',
        ]
    }
}
