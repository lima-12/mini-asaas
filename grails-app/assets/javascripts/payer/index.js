async function deletePayerWithAjax(payerId, buttonElement) {

    if(!confirm('Tem certeza que deseja remover este pagador?')) return;

    const response = await fetch(`/payer/delete/${payerId}`, {
        method: 'DELETE'
    });

    if(!response.ok) {
        alert('Ocorreu um erro ao tentar remover o pagador.');
    }

    alert('Pagador removido com sucesso!');
    window.location.reload();
}