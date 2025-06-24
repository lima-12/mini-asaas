<%@ page import="java.time.format.DateTimeFormatter; com.mini.asaas.Payment" %>

<atlas-layout
        id="paymentFormLayout"
        data-payment-id="${payment?.id}"
        data-payer-id="${payment?.payer?.id}"
        data-billing-type="${payment?.billingType}"
        data-status="${payment?.status}">

    <input type="hidden" id="paymentId" value="${payment?.id}" />

    <atlas-panel>
        <atlas-grid>
            <atlas-row>
                <atlas-col lg="6">
                    <atlas-select
                            id="payerId"
                            label="Pagador"
                            placeholder="Selecione um Pagador"
                            required
                            enable-search
                            ${payment?.id ? 'disabled' : ''}>
                        <g:each in="${payers}" var="payer">
                            <atlas-option
                                    label="${payer.name} - ${payer.cpfCnpj}"
                                    value="${payer.id}"
                                    selected="${payment?.payer?.id == payer.id}">
                            </atlas-option>
                        </g:each>
                    </atlas-select>
                </atlas-col>
                <atlas-col lg="6">
                    <atlas-select
                            id="billingType"
                            label="Pagamento"
                            placeholder="Forma de pagamento"
                            required
                            ${payment?.id ? 'disabled' : ''}>
                        <atlas-option
                                label="Boleto"
                                value="BOLETO"
                                selected="${payment?.billingType == 'BOLETO'}">
                        </atlas-option>
                        <atlas-option
                                label="Pix"
                                value="PIX"
                                selected="${payment?.billingType == 'PIX'}">
                        </atlas-option>
                        <atlas-option
                                label="Cartão de Crédito"
                                value="DEBIT_CARD"
                                selected="${payment?.billingType == 'DEBIT_CARD'}">
                        </atlas-option>
                    </atlas-select>
                </atlas-col>
                <atlas-col lg="6">
                    <atlas-money
                        id="amount"
                        label="Valor"
                        value="${payment?.amount}"
                        required
                        ${payment?.id ? 'disabled' : ''}>
                </atlas-money>
                </atlas-col>
                <atlas-col lg="6">
                    <atlas-select
                            id="status"
                            label="Status"
                            placeholder="Status de pagamento"
                            required
                            ${payment?.id ? 'disabled' : ''}>
                        <atlas-option
                                label="Aguardando"
                                value="PENDING"
                                selected="${payment?.status == 'PENDING'}">
                        </atlas-option>
                        <atlas-option
                                label="Recebido"
                                value="RECEIVED"
                                selected="${payment?.status == 'RECEIVED'}">
                        </atlas-option>
                        <atlas-option
                                label="Vencido"
                                value="OVERDUE"
                                selected="${payment?.status == 'OVERDUE'}">
                        </atlas-option>
                    </atlas-select>
                </atlas-col>
                <atlas-col lg="6">
                    <atlas-date-picker
                            id="dueDate"
                            label="Data de vencimento"
                            value="${payment?.dueDate?.format(DateTimeFormatter.ofPattern('dd/MM/yyyy'))}"
                            required>
                    </atlas-date-picker>
                </atlas-col>
            </atlas-row>
        </atlas-grid>
    </atlas-panel>
</atlas-layout>