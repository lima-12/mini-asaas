package com.mini.asaas

import grails.gorm.transactions.Transactional

@Transactional
class PayerService {

    /**
     * Retorna uma lista de todos os pagadores ativos.
     * Graças ao "soft delete", o metodo Payer.list() já exclui
     * automaticamente os registros com 'deleted = true'.
     */
    List<Payer> list() {
        return Payer.list(sort: 'nome', order: 'asc')
    }

    /**
     * Busca um pagador específico pelo seu ID.
     * O metodo Payer.get() também já respeita a regra do "soft delete".
     * @param id O ID do pagador.
     * @return O objeto Payer ou null se não for encontrado.
     */
    Payer get(Long id) {
        return Payer.get(id)
    }

    /**
     * Salva um novo pagador no banco de dados.
     * Este metodo segue a regra de ser explícito, recebendo um
     * mapa de parâmetros para criar o novo objeto.
     * @param params Um mapa com os dados do pagador (ex: [nome: "...", cpfCnpj: "..."]).
     * @return O objeto Payer salvo, ou null se a validação falhar.
     */
    @Transactional
    Payer save(String nome, String cpfCnpj, String cep, String logradouro, String numero) {
        def payer = new Payer()
        payer.nome = nome
        payer.cpfCnpj = cpfCnpj
        payer.cep = cep
        payer.logradouro = logradouro
        payer.numero = numero

        return payer.save(flush: true)
    }

    /**
     * Atualiza os dados de um pagador existente de forma explícita.
     * @param id O ID do pagador a ser atualizado.
     * @return O objeto Payer atualizado.
     */
    @Transactional
    Payer update(Long id, String nome, String cpfCnpj, String cep, String logradouro, String numero) {
        // Busca o pagador no banco de dados
        Payer pagador = Payer.get(id)

        // Se o pagador for encontrado, atualiza cada propriedade
        if (pagador) {
            pagador.nome = nome
            pagador.cpfCnpj = cpfCnpj
            pagador.cep = cep
            pagador.logradouro = logradouro
            pagador.numero = numero

            // Salva as alterações
            pagador.save(flush: true)
        }

        return pagador
    }

    /**
     * Realiza o "soft delete" de um pagador.
     * Apenas marca o campo 'deleted' como true, sem remover
     * o registro do banco de dados.
     * @param id O ID do pagador a ser "removido".
     */
    void delete(Long id) {
        Payer pagador = Payer.get(id)
        if (pagador) {
            pagador.delete()
        }
    }
}