package com.mini.asaas

import grails.gorm.transactions.Transactional

@Transactional
class PaymentService {

    List<Payment> list() {
        return Payment.list()
    }

    Payment get(Long id) {
        return Payment.get(id)
    }

    Payment save(Long customerId, Long payerId, String billingType, BigDecimal value, String status, Date dueDate) {
        Customer customer = Customer.get(customerId)
        Payer payer = Payer.get(payerId)

        if (!customer) {
            throw new IllegalArgumentException("Customer não encontrado")
        }

        if (!payer) {
            throw new IllegalArgumentException("Payer não encontrado")
        }

        Payment payment = new Payment()
        payment.customer = customer
        payment.payer = payer
        payment.billingType = billingType
        payment.value = value
        payment.status = status
        payment.dueDate = dueDate

        return payment.save(flush: true)
    }


    Payment update(Long paymentId, Long payerId, Date dueDate) {
        Payment payment = Payment.get(paymentId)

        if (!payment) {
            throw new IllegalArgumentException("Pagamento não encontrado")
        }

        Payer payer = Payer.get(payerId)

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
