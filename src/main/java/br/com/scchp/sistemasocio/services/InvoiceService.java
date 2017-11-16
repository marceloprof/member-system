package br.com.scchp.sistemasocio.services;

import br.com.scchp.sistemasocio.entities.Invoice;
import br.com.scchp.sistemasocio.exceptions.PaymentInvalidException;
import br.com.scchp.sistemasocio.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice findLastInvoicePaymentByMember(Long memberId){
        return invoiceRepository.findOneByMemberId(memberId);
    }

    public Invoice findInvoicePaymentByMemberAndDueDate(Long memberId, Date dueDate){
        return invoiceRepository.findOneByMemberAndDueDate(memberId, dueDate);
    }

    public Invoice addInvoicePayment(Invoice invoice) throws PaymentInvalidException {
        if(invoice == null || invoice.getMember() == null){
            throw new NoResultException();
        }
        Invoice payedInvoice = findInvoicePaymentByMemberAndDueDate(invoice.getMember().getId(), invoice.getDueDate());
        if(payedInvoice != null){
            throw new PaymentInvalidException("Pagamento já foi realizado no dia "+ new SimpleDateFormat("dd/MM/yyyy").format(payedInvoice.getPaymentDate()));
        }
        return invoiceRepository.save(invoice);
    }
}
