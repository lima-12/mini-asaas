package com.mini.asaas

import grails.converters.JSON

class PayerController {

    // Injeta o PayerService para que o controller possa usá-lo
    PayerService payerService

    // Ação principal: lista todos os pagadores
    def index() {
        [payerList: payerService.list()]
    }

    // Apenas exibe o formulário de criação de um novo pagador
    def create() {
        // Envia um objeto Payer vazio para a view 'create.gsp' para o formulário
        [payer: new Payer()]
    }

    // Salva o novo pagador que foi enviado pelo formulário da view 'create.gsp'
    def save() {
         // Os dados vêm do corpo da requisição, em formato JSON.
        def dados = request.JSON

        Payer pagadorSalvo = payerService.save(
                dados.nome,
                dados.cpfCnpj,
                dados.cep,
                dados.logradouro,
                dados.numero
        )

        if (pagadorSalvo.hasErrors()) {
            // Se houver erros, responde com status 400 (Bad Request) e os erros.
            response.status = 400
            render(contentType: 'application/json') {
                [errors: pagadorSalvo.errors.allErrors.collect { g.message(error: it) }]
            }
            return
        }

        // Se deu certo, responde com status 201 (Created) e o objeto salvo.
        response.status = 201
        render pagadorSalvo as JSON
    }

    // Exibe o formulário para editar um pagador existente
    def edit(Long id) {
        [payer: payerService.get(id)]
    }

    // Atualiza o pagador que foi enviado pelo formulário da view 'edit.gsp'
    def update() {
        // Busca o pagador pelo ID que vem na URL
        Payer pagador = payerService.get(params.id as Long)
        if (!pagador) {
            response.status = 404 // Not Found
            render(contentType: 'application/json') {
                [error: 'Pagador não encontrado']
            }
            return
        }

        // Os novos dados vêm do corpo da requisição JSON
        def dados = request.JSON

        Payer pagadorAtualizado = payerService.update(
                pagador.id,
                dados.nome,
                dados.cpfCnpj,
                dados.cep,
                dados.logradouro,
                dados.numero
        )

        if (pagadorAtualizado.hasErrors()) {
            response.status = 400 // Bad Request
            render(contentType: 'application/json') {
                [errors: pagadorAtualizado.errors.allErrors.collect { g.message(error: it) }]
            }
            return
        }

        render pagadorAtualizado as JSON
    }

    // Deleta (soft delete) um pagador
    def delete(Long id) {
        payerService.delete(id)
        response.status = 204 // No Content - Padrão para delete com sucesso
    }
}