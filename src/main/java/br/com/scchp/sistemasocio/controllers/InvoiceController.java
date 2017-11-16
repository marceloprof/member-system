package br.com.scchp.sistemasocio.controllers;

import br.com.scchp.sistemasocio.entities.Invoice;
import br.com.scchp.sistemasocio.exceptions.PaymentInvalidException;
import br.com.scchp.sistemasocio.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceController{

    @Autowired
    private InvoiceService invoiceService;

    @RequestMapping(method = RequestMethod.GET, params = {"memberId"})
    public ResponseEntity getLastPaymentInvoice(@RequestParam(value = "memberId") Long memberId){
        return new ResponseEntity(invoiceService.findLastInvoicePaymentByMember(memberId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addInvoicePayment(@RequestBody Invoice invoice){
        try {
            return new ResponseEntity(invoiceService.addInvoicePayment(invoice), HttpStatus.OK);
        } catch (PaymentInvalidException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }


}
