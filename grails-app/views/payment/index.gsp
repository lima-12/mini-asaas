<%@ page import="java.text.SimpleDateFormat;" defaultCodec="html" %>
<meta name="layout" content="main"/>
<asset:stylesheet src="payment/index.css"/>

<title>Lista de Pagadores</title>

<g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
</g:if>

<div class="header-container">
    <h2>Pagamentos Cadastrados</h2>
    <atlas-button appearance="primary" description="Novo Pagamento" href="${createLink(action: 'create')}"></atlas-button>
</div>

<atlas-table>
    <atlas-table-header slot="header">
        <atlas-table-col> Pagador </atlas-table-col>
        <atlas-table-col> Valor </atlas-table-col>
        <atlas-table-col> Tipo </atlas-table-col>
        <atlas-table-col> Status </atlas-table-col>
        <atlas-table-col> Vencimento </atlas-table-col>
        <atlas-table-col>  </atlas-table-col>
    </atlas-table-header>

    <atlas-table-body slot="body">
        <g:each in="${paymentList}" var="payment">
            <atlas-table-row>
                <atlas-table-col>
                    ${payment.payer.name}
                </atlas-table-col>
                <atlas-table-col>
                    ${formatNumber(number: payment.value, format: "###,##0.00", locale: 'pt_BR')}
                </atlas-table-col>
                <atlas-table-col>
                    ${payment.billingType}
                </atlas-table-col>

                <atlas-table-col>
                    <%
                        String statusPtBr
                        switch (payment.status) {
                            case 'PENDING':
                                statusPtBr = 'Aguardando'
                                break
                            case 'RECEIVED':
                                statusPtBr = 'Recebido'
                                break
                            case 'OVERDUE':
                                statusPtBr = 'Vencido'
                                break
                            default:
                                statusPtBr = payment.status
                        }
                    %>
                    ${statusPtBr}
                </atlas-table-col>
                <atlas-table-col>
                    <atlas-badge
                            text="${payment.dueDate ? new SimpleDateFormat('dd/MM/yyyy').format(payment.dueDate) : ''}"
                            theme="danger">
                    </atlas-badge>

                </atlas-table-col>

                <atlas-table-col>
                    <atlas-layout gap="2" inline>
                        <atlas-button
                                type="outlined"
                                theme="primary"
                                size="sm"
                                description="Editar"
                                href="${createLink(action: 'edit', id: payment.id)}">
                        </atlas-button>

                        <atlas-button
                                class="delete-payment-btn"
                                data-payment-id="${payment.id}"
                                type="outlined"
                                theme="danger"
                                size="sm"
                                description="Deletar">
                        </atlas-button>
                    </atlas-layout>
                </atlas-table-col>
            </atlas-table-row>
        </g:each>
    </atlas-table-body>
</atlas-table>


<asset:javascript src="payment/index.js"/>