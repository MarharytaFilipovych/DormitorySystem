package billing;

import enums.PaymentMethod;

import java.util.Date;
import java.util.Objects;

public class Payment {
    private final long id;
    private final Date paymentDate;
    private final PaymentMethod method;

    public Payment(long id, PaymentMethod method) {
        this.id = id;
        paymentDate = new Date();
        this.method = method;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id && Objects.equals(paymentDate, payment.paymentDate) && method == payment.method;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentDate, method);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentDate=" + paymentDate +
                ", method=" + method +
                '}';
    }
}
