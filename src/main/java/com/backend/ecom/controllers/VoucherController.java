package main.java.com.backend.ecom.controllers;

import main.java.com.backend.ecom.entities.Voucher;
import main.java.com.backend.ecom.payload.response.ResponseObject;
import main.java.com.backend.ecom.services.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/vouchers")
public class VoucherController {
    @Autowired
    private VoucherService voucherService;

    @GetMapping("/all")
    public ResponseEntity<ResponseObject> getAllVouchers() {
        return voucherService.getAllVouchers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getVoucherDetail(@PathVariable("id") Long id) {
        return voucherService.getVoucherDetail(id);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseObject> createVoucher(@RequestBody Voucher voucherRequest) {
        return voucherService.createVoucher(voucherRequest);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateVoucher(@PathVariable("id") Long id, @RequestBody Voucher voucherRequest) {
        return voucherService.updateVoucher(id, voucherRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteVoucher(@PathVariable("id") Long id) {
        return voucherService.deleteVoucher(id);
    }
}
