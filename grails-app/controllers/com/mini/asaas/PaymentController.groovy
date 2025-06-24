package com.mini.asaas

import grails.converters.JSON

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class PaymentController {

    PaymentService paymentService

    def index() {
        [paymentList: paymentService.list()]
    }

    def create() {
        [
                payment: new Payment(),
                payers: Payer.list()
        ]
    }

    def save() {
        def requestData = request.JSON

        try {

            def rawAmount = requestData.amount.toString()
                    .replace('.', '')
                    .replace(',', '.')
            def parsedAmount = new BigDecimal(rawAmount)

            def formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            LocalDate parsedDueDate = LocalDate.parse(requestData.dueDate, formatter)

            def payment = paymentService.save(
                    requestData.payerId as Long,
                    requestData.billingType,
                    parsedAmount,
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

            def formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            LocalDate parsedDueDate = LocalDate.parse(requestData.dueDate, formatter)

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
