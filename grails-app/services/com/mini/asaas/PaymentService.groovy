package com.mini.asaas

import grails.gorm.transactions.Transactional

import java.time.LocalDate

@Transactional
class PaymentService {

    List<Payment> list() {
        return Payment.list()
    }

    Payment get(Long id) {
        return Payment.get(id)
    }

    Payment save(Long payerId, String billingType, BigDecimal amount, String status, LocalDate dueDateStr) {
        def payer = Payer.get(payerId)

        if (!payer) {
            throw new IllegalArgumentException("Payer não encontrado")
        }

        def payment = new Payment()
        payment.payer = payer
        payment.billingType = billingType
        payment.amount = amount
        payment.status = status
        payment.dueDate = dueDateStr

        return payment.save(flush: true)
    }


    Payment update(Long paymentId, Long payerId, LocalDate dueDate) {
        def payment = Payment.get(paymentId)

        if (!payment) {
            throw new IllegalArgumentException("Pagamento não encontrado")
        }

        def payer = Payer.get(payerId)

        if (!payer) {
            throw new IllegalArgumentException("Payer não encontrado")
        }

        payment.dueDate = dueDate

        return payment.save(flush: true)
    }


    void delete(Long id) {
        Payment payment = Payment.get(id)
        if (payment) {
            payment.delete()
        }
    }
}
