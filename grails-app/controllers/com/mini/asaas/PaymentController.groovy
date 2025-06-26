package com.mini.asaas

import grails.converters.JSON

import java.text.SimpleDateFormat

class PaymentController {

    PaymentService paymentService

    def index() {
        [paymentList: paymentService.list()]
    }

    def create() {
        Customer customer = Customer.get(1)

        [
                customer: customer,
                payment: new Payment(),
                payers: Payer.list()
        ]
    }

    def save() {
        def requestData = request.JSON

        try {

            def rawValue = requestData.value.toString()
                    .replace('.', '')
                    .replace(',', '.')
            def parsedValue = new BigDecimal(rawValue)

            def formatter = new SimpleDateFormat("dd/MM/yyyy")
            Date parsedDueDate = formatter.parse(requestData.dueDate)

            def payment = paymentService.save(
                    requestData.customerId as Long,
                    requestData.payerId as Long,
                    requestData.billingType,
                    parsedValue,
                    requestData.status,
                    parsedDueDate
            )

            if (payment.hasErrors()) {
                response.status = 400
                render(contentType: 'application/json') {
                    [errors: payment.errors.allErrors.collect { g.message(error: it) }]
                }
                return
            }

            response.status = 201
            render payment as JSON

        } catch (IllegalArgumentException e) {
            response.status = 400
            render(contentType: 'application/json') {
                [error: e.message]
            }

        } catch (Exception e) {
            response.status = 500
            render(contentType: 'application/json') {
                [error: e.message]
            }
        }
    }

    def edit(Long id) {
        [
                payment: paymentService.get(id),
                payers: Payer.list()
        ]
    }

    def update() {
        Payment existingPayment = paymentService.get(params.id as Long)
        if (!existingPayment) {
            response.status = 404
            render(contentType: 'application/json') {
                [error: 'Pagamento não encontrado']
            }
            return
        }

        def requestData = request.JSON

        try {

            def formatter = new SimpleDateFormat("dd/MM/yyyy")
            Date parsedDueDate = formatter.parse(requestData.dueDate)

            def payment = paymentService.update(
                    existingPayment.id,
                    requestData.payerId as Long,
                    parsedDueDate
            )

            if (payment.hasErrors()) {
                response.status = 400
                render(contentType: 'application/json') {
                    [errors: payment.errors.allErrors.collect { g.message(error: it) }]
                }
                return
            }

            response.status = 200
            render payment as JSON

        } catch (IllegalArgumentException e) {
            response.status = 400
            render(contentType: 'application/json') {
                [error: e.message]
            }
        } catch (Exception e) {
            response.status = 500
            render(contentType: 'application/json') {
                [error: e.message]
            }
        }
    }

    def delete(Long id) {
        paymentService.delete(id)
        response.status = 204
    }
}
