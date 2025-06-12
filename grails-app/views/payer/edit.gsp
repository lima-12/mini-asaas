<meta name="layout" content="main"/>
<title>Editar Pagador</title>

<g:render template="form" model="[payer: payer]"/>

<atlas-layout gap="2" inline style="margin-top: 1rem;">
    <atlas-button
            description="Atualizar"
            appearance="primary"
            onclick="atualizarPagadorComAjax()">
    </atlas-button>
    <atlas-button
            description="Cancelar"
            appearance="secondary"
            href="${createLink(action: 'index')}">
    </atlas-button>
</atlas-layout>

<script type="text/javascript">
    // Passando o ID do pagador para a função JavaScript
    const payerId = ${payer.id};

    async function atualizarPagadorComAjax() {
        const dadosPagador = {
            nome: document.getElementById('nome').value,
            cpfCnpj: document.getElementById('cpfCnpj').value,
            cep: document.getElementById('cep').value,
            logradouro: document.getElementById('logradouro').value,
            numero: document.getElementById('numero').value
        };

        const response = await fetch('${createLink(action: 'update')}/' + payerId, {
            method: 'PUT', // Metodo HTTP correto para atualização
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dadosPagador)
        });

        if (response.ok) {
            // alert('Pagador atualizado com sucesso!');
            window.location.href = '${createLink(action: 'index')}';
        } else {
            const errorData = await response.json();
            alert('Erro ao atualizar: \n' + (errorData.errors ? errorData.errors.join('\n') : errorData.error));
        }
    }
</script>