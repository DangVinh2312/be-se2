package main.java.com.backend.ecom.services;

import main.java.com.backend.ecom.entities.Voucher;
import main.java.com.backend.ecom.exception.ResourceNotFoundException;
import main.java.com.backend.ecom.payload.response.ResponseObject;
import main.java.com.backend.ecom.repositories.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;

    public ResponseEntity<ResponseObject> getAllVouchers() {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Get all voucher!", voucherRepository.findAll()));
    }

    public ResponseEntity<ResponseObject> getVoucherDetail(Long id) {
        Voucher voucher = voucherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found voucher with id:" + id));
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Voucher details found!", voucher));
    }

    public ResponseEntity<ResponseObject> createVoucher(Voucher voucherRequest) {
        boolean exist = voucherRepository.existsByName(voucherRequest.getName());
        if(exist){
            throw new ResourceNotFoundException("Voucher is already existed");
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "New voucher created",voucherRepository.save(voucherRequest)));

    }

    public ResponseEntity<ResponseObject> updateVoucher(Long id, Voucher voucherRequest) {
        Voucher voucher = voucherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found voucher with id:" + id));

        voucher.setName(voucherRequest.getName());
        voucher.setDescription(voucherRequest.getDescription());
        voucher.setStartDate(voucherRequest.getStartDate());
        voucher.setEndDate(voucherRequest.getEndDate());
        voucher.setReductionPercentage(voucherRequest.getReductionPercentage());
        voucher.setMaxReduction(voucherRequest.getMaxReduction());

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Voucher updated!", voucherRepository.save(voucher)));
    }

    public ResponseEntity<ResponseObject> deleteVoucher(Long id) {
        if (!voucherRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found voucher with id:" + id);
        }
        voucherRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete voucher successfully", ""));

    }

}
