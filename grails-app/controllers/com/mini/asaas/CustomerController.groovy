package com.mini.asaas

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CustomerController {

    CustomerService customerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerService.list(params), model:[customerCount: customerService.count()]
    }

    def show(Long id) {
        respond customerService.get(id)
    }

    def create() {
        respond new Customer(params)
    }

    def save() {
        
        try {
            Customer customer = customerService.save(params)
            request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customer.label', default: 'Customer'), customer.id])
                redirect customer
            }
            '*' { respond customer, [status: CREATED] }
            }
        } catch (ValidationException e) {
            respond customer.errors, view:'create'
            return
        }
        
    }

    def edit(Long id) {
        respond customerService.get(id)
    }

    def update() {

        try {
            Customer customer = Customer.get(params.id)
            if (!customer) {
                notFound()
                return
            }
            customerService.update(customer, params)
            request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customer.label', default: 'Customer'), customer.id])
                redirect customer
            }
            '*'{ respond customer, [status: OK] }
        }
        } catch (ValidationException e) {
            respond customer.errors, view:'edit'
            return
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customer.label', default: 'Customer'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customer.label', default: 'Customer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
