package com.groupproject.services;

import com.groupproject.entities.Book;
import com.groupproject.entities.Order;
import com.groupproject.entities.OrderDetails;
import com.groupproject.repository.BookRepository;
import com.groupproject.repository.OrderDetailsRepository;
import com.groupproject.repository.OrderRepository;
import com.groupproject.requests.OrderDetailsRequest;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderDetailsServiceImpl implements IOrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<OrderDetails> getAll() {

        log.info("Ready to get all orderDetails from the given id");
        return orderDetailsRepository.findAll();
    }

    @Override
    public OrderDetails getOrderDetailsById(Long id) {

        log.info("Ready to get an orderDetails from the given id");
        return orderDetailsRepository.findById(id).orElse(null);
    }

    @Override
    public boolean createOrderDetails(OrderDetailsRequest request) {

        Long orderId= request.getOrderId();
        Long bookId= request.getBookId();
        Order order=orderRepository.findById(orderId).orElse(null);
        Book book=bookRepository.findById(bookId).orElse(null);

        log.info("Ready to insert a new OrderDetails");
        OrderDetails orderDetails = new OrderDetails(order, book, request.getOriginalPrice(), request.getDiscountRate(), request.getTotalPrice());
        OrderDetails newOrderDetails = orderDetailsRepository.save(orderDetails);
        log.info("The new orderDetails is {}", newOrderDetails);
        log.info("The orderDetails have been inserted to the DB");
        return true;
    }

    @Override
    public OrderDetails updateOrderDetails(Long id, OrderDetailsRequest request) {

        log.info("Ready to update an existing orderdetails");
        if (orderDetailsRepository.findById(id).isPresent()) {
            Long orderId= request.getOrderId();
            Long bookId= request.getBookId();
            Order order=orderRepository.findById(orderId).orElse(null);
            Book book=bookRepository.findById(bookId).orElse(null);
            OrderDetails existingOrderDetails = orderDetailsRepository.findById(id).get();
            existingOrderDetails.setOrder(order);
            existingOrderDetails.setBook(book);
            existingOrderDetails.setOriginalPrice(request.getOriginalPrice());
            existingOrderDetails.setDiscountRate(request.getDiscountRate());
            existingOrderDetails.setTotalPrice(request.getTotalPrice());
            OrderDetails updatedOrderDetails = orderDetailsRepository.save(existingOrderDetails);
            log.info("The updated OrderDetails is {}", updatedOrderDetails);
            log.info("The updated OrderDetails has been inserted to the DB");
            return updatedOrderDetails;
        }
        log.info("The order details have not been inserted to the DB");
        return null;
    }

    @Override
    public boolean deleteById(Long id) {

        log.info("Ready to delete an orderDetails");
        if (orderDetailsRepository.existsById(id)) {
            orderDetailsRepository.deleteById(id);
            log.info("orderDetails deleted successfully");
            return true;
        }
        log.info("orderDetails has not deleted successfully");
        return false;
    }
}
