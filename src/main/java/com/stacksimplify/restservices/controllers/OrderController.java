package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.OrderRepository;
import com.stacksimplify.restservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class OrderController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    //get all Orders for a user
    @GetMapping("/{userId}/orders")
    public List<Order> getAllOrders(@PathVariable Long userId) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User Not Found");
        }

        return userOptional.get().getOrders();
    }

    //Create Order
    @PostMapping("/{userId}/orders")
    public Order createOrder(@PathVariable Long userId, @RequestBody Order order) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User Not Found");
        }

        User user = userOptional.get();
        order.setUser(user);
        return orderRepository.save(order);
    }

}
