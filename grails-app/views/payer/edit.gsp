<meta name="layout" content="main"/>
<title>Editar Pagador</title>

<g:render template="form" model="[payer: payer]"/>

<atlas-layout gap="2" inline>
    <atlas-button
            description="Atualizar"
            appearance="primary"
            onclick="updatePayerWithAjax()">
    </atlas-button>
    <atlas-button
            description="Cancelar"
            appearance="secondary"
            href="${createLink(action: 'index')}">
    </atlas-button>
</atlas-layout>

<asset:javascript src="payer/edit.js" />