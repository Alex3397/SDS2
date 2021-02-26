package com.semanadev.delivery.services;

import com.semanadev.delivery.dto.OrderDTO;
import com.semanadev.delivery.dto.ProductDTO;
import com.semanadev.delivery.entities.Order;
import com.semanadev.delivery.entities.OrderStatus;
import com.semanadev.delivery.entities.Product;
import com.semanadev.delivery.repositories.OrderRepository;
import com.semanadev.delivery.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findPending() {
        List<Order> list = repository.findOrdersWithProducts();
        return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> list = repository.findAll();
        return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order(null,dto.getAddress(),dto.getLatitude(),dto.getLongitude(), Instant.now(), OrderStatus.PENDING);
        for (ProductDTO p : dto.getProducts()) {
            Product product = productRepository.getOne(p.getId());
            order.getProducts().add(product);
        }
        order = repository.save(order);
        return new OrderDTO(order);
    }
    
    //@Transactional
    public void changeStatus(Long id) {
        Order order = repository.getOne(id);
        //TODO implementar multiplas opções de atualização de status se necessário
    }

    @Transactional
    public OrderDTO setReceived(Long id) {
        Order order = repository.getOne(id);
        order.setStatus(OrderStatus.ORDER_RECEIVED);
        order = repository.save(order);
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO setPreparing(Long id) {
        Order order = repository.getOne(id);
        order.setStatus(OrderStatus.PREPARING);
        order = repository.save(order);
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO setAwaiting(Long id) {
        Order order = repository.getOne(id);
        order.setStatus(OrderStatus.AWAITING_DELIVERYMAN);
        order = repository.save(order);
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO setShipping(Long id) {
        Order order = repository.getOne(id);
        order.setStatus(OrderStatus.SHIPPING);
        order = repository.save(order);
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO setDelivered(Long id) {
        Order order = repository.getOne(id);
        order.setStatus(OrderStatus.DELIVERED);
        order = repository.save(order);
        return new OrderDTO(order);
    }
}
