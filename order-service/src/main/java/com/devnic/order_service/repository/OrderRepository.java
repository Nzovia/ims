package com.devnic.order_service.repository;


import com.devnic.order_service.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Nicholas Nzovia
 * @On 26/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

public interface OrderRepository extends JpaRepository<Order, Long> {
}
