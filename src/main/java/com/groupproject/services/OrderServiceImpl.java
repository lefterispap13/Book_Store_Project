package com.groupproject.services;

import com.groupproject.entities.Account;
import com.groupproject.entities.Order;
import com.groupproject.entities.OrderDetails;
import com.groupproject.repository.AccountRepository;
import com.groupproject.repository.OrderDetailsRepository;
import com.groupproject.repository.OrderRepository;
import com.groupproject.requests.OrderRequest;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Override
    public List<Order> getAll() {

        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        log.info("Ready to find order by id");
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getOrdersByAccountId(Long accountId) {
        log.info("Ready to find Order by account id {}",accountId);
        return orderRepository.findOrderByAccount_AccountId(accountId);
    }

    @Override
    public boolean createOrder(OrderRequest request) {

        //want instead of the whole account to give only accountId
        log.info("Ready to find th account");
        Long accountId= request.getAccountId();
        Account account=accountRepository.findById(accountId).orElse(null);

//        //want instead of the whole orderDetails to give only a list of orderDetailsIds
//        List<Long> orderDetailsIds= request.getOrderDetailsIds();
//        Set<OrderDetails> orderDetailsSet=new HashSet<>();
//        for (Long current: orderDetailsIds){
//            OrderDetails orderDetails=orderDetailsRepository.findById(current).orElse(null);
//            log.info("Ready to add all the order details");
//            orderDetailsSet.add(orderDetails);
//        }
        log.info("Ready to insert a new Order");
        LocalDateTime now = LocalDateTime.now();
        Order order = new Order(now, account, request.getTotalCoins());
        Order newOrder = orderRepository.save(order);
        log.info("The new order is {}", newOrder);
        log.info("The order has been inserted to the DB");
        return true;
    }

//    @Override
//    public OrderRequest updateOrder(Long id, OrderRequest request) {
//
//        log.info("Ready to update the given order");
//        if (orderRepository.findById(id).isPresent()) {
//            Order existingOrder = orderRepository.findById(id).get();
//            existingOrder.setOrderDate(request.getOrderDate());//is it ok to update the order date time?
//            existingOrder.setOrderDetails(request.getOrderDetails());
//            existingOrder.setTotalCoins(request.getTotalCoins());
//            Order updatedOrder = orderRepository.save(existingOrder);
//            log.info("The updated order is {}", updatedOrder);
//            log.info("The updated order has been inserted to the DB");
//            return new OrderRequest(updatedOrder.getOrderDate(), updatedOrder.getAccount(), updatedOrder.getTotalCoins(), updatedOrder.getOrderDetails());
//        }
//        log.info("The order didn't get updated");
//        return null;
//    }

    @Override
    public boolean deleteById(Long id) {

        log.info("Ready to delete an Order");
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            log.info("Order successfully deleted");
            return true;
        }
        log.info("Order wasn't deleted successfully");
        return false;
    }
}
