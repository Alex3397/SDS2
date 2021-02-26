package com.semanadev.delivery.controllers;

import com.semanadev.delivery.dto.OrderDTO;
import com.semanadev.delivery.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findPending() {
        List<OrderDTO> list = service.findPending();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/dev/all")
    public ResponseEntity<List<OrderDTO>> findAll() {
        List<OrderDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}/received")
    public ResponseEntity<OrderDTO> setReceived(@PathVariable Long id) {
        OrderDTO dto = service.setReceived(id);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/{id}/preparing")
    public ResponseEntity<OrderDTO> setDPreparing(@PathVariable Long id) {
        OrderDTO dto = service.setPreparing(id);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/{id}/awaiting")
    public ResponseEntity<OrderDTO> setAwaiting(@PathVariable Long id) {
        OrderDTO dto = service.setAwaiting(id);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/{id}/shipping")
    public ResponseEntity<OrderDTO> setShipping(@PathVariable Long id) {
        OrderDTO dto = service.setShipping(id);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/{id}/delivered")
    public ResponseEntity<OrderDTO> setDelivered(@PathVariable Long id) {
        OrderDTO dto = service.setDelivered(id);
        return ResponseEntity.ok().body(dto);
    }

}
