package billing;

import accomodation.Room;
import application.Application;
import enums.InvoiceStatus;
import user.Student;

import java.util.*;

public class BillingService {
    private final Map<Student, List<Invoice>> invoices;

    public BillingService() {
        this.invoices = new HashMap<>();
    }

    public Invoice generateInvoice(Student student, Application application) {
        Room preferredRoom = application.getPreferences().getFirst();
        double roomPrice = preferredRoom.getPrice();

        Invoice invoice = new Invoice(
                System.currentTimeMillis(),
                preferredRoom.getId(),
                roomPrice,
                new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000)
        );

        if (!invoices.containsKey(student))invoices.put(student, new ArrayList<>());
        invoices.get(student).add(invoice);

        System.out.println("Invoice generated for student " + student.getId() + " for room " + preferredRoom.getId());
        return invoice;
    }

    public List<Invoice> getInvoicesByStudent(Student student) {
        return invoices.getOrDefault(student, new ArrayList<>());
    }

    public List<Invoice> getOutstandingInvoices() {
        List<Invoice> outstandingInvoices = new ArrayList<>();
        for (List<Invoice> studentInvoices : invoices.values()) {
            for (Invoice invoice : studentInvoices) {
                if (invoice.getStatus() == InvoiceStatus.PENDING || invoice.getStatus() == InvoiceStatus.OVERDUE)outstandingInvoices.add(invoice);
            }
        }
        return outstandingInvoices;
    }

    public Map<Student, List<Invoice>> getInvoices() { return invoices; }
}
