async function updatePaymentWithAjax() {
    const paymentId = document.getElementById('paymentId')?.value;

    const paymentData = {
        payerId: document.getElementById('payerId')?.value,
        dueDate: document.getElementById('dueDate')?.value
    };

    const response = await fetch(`/payment/update/${paymentId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(paymentData)
    });

    if (!response.ok) {
        const errorData = await response.json();
        alert('Erro ao atualizar pagamento:\n' + (errorData.errors ? errorData.errors.join('\n') : errorData.error));
        return;
    }

    window.location.href = '/payment/index';
}

document.addEventListener("DOMContentLoaded", () => {
    const layout = document.getElementById("paymentFormLayout");

    const payerId = layout.dataset.payerId;
    const billingType = layout.dataset.billingType;
    const status = layout.dataset.status;

    if (payerId) {
        document.getElementById("payerId").value = payerId;
    }

    if (billingType) {
        document.getElementById("billingType").value = billingType;
    }

    if (status) {
        document.getElementById("status").value = status;
    }
});
