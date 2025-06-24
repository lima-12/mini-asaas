package com.mini.asaas

import com.mini.asaas.base.BaseEntity
import java.time.LocalDate

class Payment extends BaseEntity {

    Payer payer
    BigDecimal amount
    String billingType
    String status
    LocalDate dueDate

    static constraints = {
        payer nullable: false
        amount nullable: false
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
