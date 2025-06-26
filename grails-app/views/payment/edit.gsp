<meta name="layout" content="main"/>
<title>Editar Pagamento</title>

<g:render template="form" model="[payment: payment]"/>

<atlas-layout gap="2" inline>
    <atlas-button
            id="updatePaymentBtn"
            description="Atualizar"
            appearance="primary"
    >
    </atlas-button>
    <atlas-button
            description="Cancelar"
            appearance="secondary"
            href="${createLink(action: 'index')}">
    </atlas-button>
</atlas-layout>

<asset:javascript src="payment/edit.js" />