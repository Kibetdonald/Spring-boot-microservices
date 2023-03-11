package com.springmicroservices.orderService.Repository;

import com.springmicroservices.orderService.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
