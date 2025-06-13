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
        return Payer.list(sort: 'name', order: 'asc')
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
     * @param params Um mapa com os dados do pagador (ex: [name: "...", cpfCnpj: "..."]).
     * @return O objeto Payer salvo, ou null se a validação falhar.
     */
    @Transactional
    Payer save(String name, String email, String cpfCnpj, String postalCode, String adress, String adressNumber) {
        def payer = new Payer()
        payer.name = name
        payer.email = email
        payer.cpfCnpj = cpfCnpj
        payer.postalCode = postalCode
        payer.adress = adress
        payer.adressNumber = adressNumber

        return payer.save(flush: true)
    }

    /**
     * Atualiza os dados de um pagador existente de forma explícita.
     * @param id O ID do pagador a ser atualizado.
     * @return O objeto Payer atualizado.
     */
    @Transactional
    Payer update(Long id, String name, String email, String cpfCnpj, String postalCode, String adress, String adressNumber) {
        Payer payer = Payer.get(id)

        if (payer) {
            payer.name = name
            payer.email = email
            payer.cpfCnpj = cpfCnpj
            payer.postalCode = postalCode
            payer.adress = adress
            payer.adressNumber = adressNumber

            payer.save(flush: true)
        }

        return payer
    }

    /**
     * Realiza o "soft delete" de um pagador.
     * Apenas marca o campo 'deleted' como true, sem remover
     * o registro do banco de dados.
     * @param id O ID do pagador a ser "removido".
     */
    void delete(Long id) {
        Payer payer = Payer.get(id)
        if (payer) {
            payer.delete()
        }
    }
}