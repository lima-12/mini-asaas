package com.mini.asaas

import grails.converters.JSON

class PayerController {

    PayerService payerService

    def index() {
        [payerList: payerService.list()]
    }

    def create() {
        [payer: new Payer()]
    }

    def save() {
        def requestData = request.JSON

        Payer payerSave = payerService.save(
                requestData.name,
                requestData.email,
                requestData.cpfCnpj,
                requestData.postalCode,
                requestData.address,
                requestData.addressNumber
        )

        if (payerSave.hasErrors()) {
            response.status = 400
            render(contentType: 'application/json') {
                [errors: payerSave.errors.allErrors.collect { g.message(error: it) }]
            }
            return
        }

        response.status = 201
        render payerSave as JSON
    }

    def edit(Long id) {
        [payer: payerService.get(id)]
    }

    def update() {
        Payer existingPayer = payerService.get(params.id as Long)

        if (!existingPayer) {
            response.status = 404
            render(contentType: 'application/json') {
                [error: 'Pagador não encontrado']
            }
            return
        }

        def requestData = request.JSON

        Payer updatedPayer = payerService.update(
                existingPayer.id,
                requestData.name,
                requestData.email,
                requestData.cpfCnpj,
                requestData.postalCode,
                requestData.address,
                requestData.addressNumber
        )

        if (updatedPayer.hasErrors()) {
            response.status = 400
            render(contentType: 'application/json') {
                [errors: updatedPayer.errors.allErrors.collect { g.message(error: it) }]
            }
            return
        }

        render updatedPayer as JSON
    }

    def delete(Long id) {
        payerService.delete(id)
        response.status = 204
    }
}