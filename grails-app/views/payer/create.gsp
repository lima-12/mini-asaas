<meta name="layout" content="main"/>
<title>Criar Novo Pagador</title>

<g:render template="form"/>


<atlas-layout gap="2" inline>
    <atlas-button
            description="Salvar"
            appearance="primary"
            onclick="savePayerWithAjax()">
    </atlas-button>
    <atlas-button
            description="Cancelar"
            appearance="secondary"
            href="${createLink(action: 'index')}">
    </atlas-button>
</atlas-layout>

<asset:javascript src="payer/create.js"/>
