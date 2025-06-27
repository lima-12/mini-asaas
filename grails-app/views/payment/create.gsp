<meta name="layout" content="main"/>
<title>Criar Novo Pagamento</title>

%{--${customer.properties}--}%

<g:render template="form"/>

<atlas-layout gap="2" inline>
    <atlas-button
            id="createPaymentBtn"
            theme="primary"
            description="Salvar">
    </atlas-button>
    <atlas-button
            theme="primary"
            description="Cancelar"
            href="${createLink(controller: 'payment', action: 'index')}">
    </atlas-button>
</atlas-layout>

<asset:javascript src="payment/create.js" />