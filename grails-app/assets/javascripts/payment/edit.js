function PaymentEditController() {
    this.reference = document.getElementById("paymentFormLayout");

    this.init = function () {
        this.populateSelects();
        this.setupListeners();
    }

    this.populateSelects = function () {
        const payerId = this.reference.dataset.payerId;
        const billingType = this.reference.dataset.billingType;
        const status = this.reference.dataset.status;

        if (payerId) {
            document.getElementById("payerId").value = payerId;
        }

        if (billingType) {
            document.getElementById("billingType").value = billingType;
        }

        if (status) {
            document.getElementById("status").value = status;
        }
    }

    this.setupListeners = function () {
        const button = document.getElementById("updatePaymentBtn");
        if (button) {
            button.addEventListener("click", () => this.updatePaymentWithAjax());
        }
    }

    this.updatePaymentWithAjax = async function () {
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
            alert('Erro ao atualizar pagamento:\n' +
                (errorData.errors ? errorData.errors.join('\n') : errorData.error));
            return;
        }

        window.location.href = '/payment/index';
    }
}

document.addEventListener("DOMContentLoaded", function () {
    const controller = new PaymentEditController();
    controller.init();
});

