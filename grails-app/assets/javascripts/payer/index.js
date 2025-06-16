
async function deletePayerWithAjax(payerId, buttonElement) {
    if (confirm('Tem certeza que deseja remover este pagador?')) {

        const response = await fetch(`/payer/delete/${payerId}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            const row = buttonElement.closest('atlas-table-row');
            if (row) {
                row.remove();
            }
            alert('Pagador removido com sucesso!');
        } else {
            alert('Ocorreu um erro ao tentar remover o pagador.');
        }
    }
}
