package billing;

import enums.InvoiceStatus;
import enums.Status;
import java.util.Date;
import java.util.Objects;

public class Invoice {
    private final long id;
    private final long roomId;
    private double price;
    private final Date issueDate;
    private Date dueDate;
    private InvoiceStatus status = InvoiceStatus.PENDING;
    private Payment payment = null;

    public Invoice(long id, long roomId, double price, Date dueDate) {
        this.id = id;
        this.roomId = roomId;
        this.price = price;
        this.issueDate = new Date();
        this.dueDate = dueDate;
    }

    public long getId() {
        return id;
    }

    public long getRoomId() {
        return roomId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return id == invoice.id && roomId == invoice.roomId && Double.compare(price, invoice.price) == 0 && Objects.equals(issueDate, invoice.issueDate) && Objects.equals(dueDate, invoice.dueDate) && status == invoice.status && Objects.equals(payment, invoice.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomId, price, issueDate, dueDate, status, payment);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", roomId=" + roomId +
                ", price=" + price +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                ", status=" + status +
                ", payment=" + payment.toString() +
                '}';
    }
}
