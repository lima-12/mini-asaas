async function deletePaymentWithAjax(paymentId) {

    if(!confirm('Tem certeza que deseja remover este pagamento?')) return;

    const response = await fetch(`/payment/delete/${paymentId}`, {
        method: 'DELETE'
    });

    if(!response.ok) {
        alert('Ocorreu um erro ao tentar remover o pagamento.');
    }

    alert('Pagamento removido com sucesso!');
    window.location.reload();
}