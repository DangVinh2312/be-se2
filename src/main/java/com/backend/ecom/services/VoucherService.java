package com.backend.ecom.services;

import com.backend.ecom.entities.Brand;
import com.backend.ecom.entities.Voucher;
import com.backend.ecom.exception.ResourceNotFoundException;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.repositories.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;

    public List<Voucher> getAllVouchers() {
        return voucherRepository.findAll();
    }

    public ResponseEntity<ResponseObject> getVoucherDetail(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete voucher successfully", ""));
    }

    public ResponseEntity<ResponseObject> createVoucher(Voucher voucherRequest) {
        boolean exist = voucherRepository.existsByName(voucherRequest.getName());
        if(exist){
            throw new ResourceNotFoundException("Voucher is already existed");
        }
        voucherRepository.save(voucherRequest);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete voucher successfully", ""));

    }

    public ResponseEntity<ResponseObject> updateVoucher(Long id, Voucher voucherRequest) {
        Voucher voucher = voucherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found voucher with id:" + id));
        voucher.setName(voucherRequest.getName());
        voucher.setDescription(voucherRequest.getDescription());
        voucher.setStartDate(voucherRequest.getStartDate());
        voucher.setEndDate(voucherRequest.getEndDate());
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete voucher successfully", ""));
    }

    public ResponseEntity<ResponseObject> deleteVoucher(Long id) {
        if (!voucherRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found voucher with id:" + id);
        }
        voucherRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete voucher successfully", ""));

    }

}
