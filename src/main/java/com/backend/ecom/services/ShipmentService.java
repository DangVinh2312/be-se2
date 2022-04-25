package com.backend.ecom.services;

import com.backend.ecom.entities.Shipment;
import com.backend.ecom.exception.ResourceNotFoundException;
import com.backend.ecom.payload.response.ResponseObject;
import com.backend.ecom.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService {
    @Autowired
    ShipmentRepository shipmentRepository;

    public ResponseEntity<ResponseObject> getAllShipment(){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Get all shipments", shipmentRepository.findAll()));
    }

    public ResponseEntity<ResponseObject> getShipmentDetail(Long id){
        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot find shipment with id: " +id));
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Shipment found!", shipment));
    }

    public ResponseEntity<ResponseObject> updateShipment(Long id, Shipment updateShipment){
        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot find shipment with id: " +id));

        shipment.setStatus(updateShipment.getStatus());
        shipment.setEstimatedArrivalDate(updateShipment.getEstimatedArrivalDate());
        shipment.setStartDate(updateShipment.getStartDate());
        shipment.setTransaction(updateShipment.getTransaction());

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Shipment info updated!", shipmentRepository.save(shipment)));
    }

    public ResponseEntity<ResponseObject> deleteShipment(Long id){
        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot find shipment with id: " +id));
        shipmentRepository.delete(shipment);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Shipment deleted!", ""));
    }

    public ResponseEntity<ResponseObject> createShipment(Shipment shipment){
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject("ok", "Shipment created!", shipmentRepository.save(shipment)));
    }

}
