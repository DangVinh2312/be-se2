package com.backend.ecom.controllers;

import com.backend.ecom.services.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class VoucherController {
    @Autowired
    private VoucherService voucherService;
}
