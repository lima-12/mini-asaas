<meta name="layout" content="main"/>
<title>Criar Novo Pagador</title>

<g:render template="form"/>

<atlas-layout gap="2" inline style="margin-top: 1rem;">
    <atlas-button
            description="Salvar"
            appearance="primary"
            onclick="salvarPagadorComAjax()">
    </atlas-button>
    <atlas-button
            description="Cancelar"
            appearance="secondary"
            href="${createLink(action: 'index')}">
    </atlas-button>
</atlas-layout>

<script type="text/javascript">
    async function salvarPagadorComAjax() {
        // Coleta os valores de cada campo do Atlas pelo seu ID.
        const dadosPagador = {
            nome: document.getElementById('nome').value,
            cpfCnpj: document.getElementById('cpfCnpj').value,
            cep: document.getElementById('cep').value,
            logradouro: document.getElementById('logradouro').value,
            numero: document.getElementById('numero').value
        };

        // Usa a API 'fetch' do JavaScript para enviar os dados
        const response = await fetch('${createLink(action: 'save')}', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dadosPagador)
        });

        // Trata a resposta do servidor
        if (response.ok) {
            // alert('Pagador criado com sucesso!');
            window.location.href = '${createLink(action: 'index')}';
        } else {
            // const errorData = await response.json();
            alert('Erro ao salvar: \n' + errorData.errors.join('\n'));
        }
    }
</script>