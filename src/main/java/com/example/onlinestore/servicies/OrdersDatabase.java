package com.example.onlinestore.servicies;

import com.example.onlinestore.model.Orders;
import com.example.onlinestore.model.User;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.Id;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.example.onlinestore.servicies.FileSystemService.getPathToFile;

public class OrdersDatabase {

    private static ObjectRepository<Orders> orderRepository;

    private String clientID;

    private static int nextOrderId;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("orders.db").toFile())
                .openOrCreate("test", "test");

        orderRepository = database.getRepository(Orders.class);
    }

    /*public static void deleteDatabase() {
        orderRepository.close();
        boolean deleted = getPathToFile("Orders.db").toFile().delete();
        if (deleted) {
            System.out.println("Database deleted successfully.");
        } else {
            System.out.println("Failed to delete the database.");
        }
    }*/


    public static void addOrder(Orders order) {


        if (nextOrderId == 0) {
            // Find the maximum orderId in the collection
            int maxOrderId = orderRepository.find().toList().stream()
                    .mapToInt(Orders::getOrderId)
                    .max()
                    .orElse(0);
            nextOrderId = maxOrderId + 1;
        }
        order.setOrderId(nextOrderId++);
        orderRepository.insert(order);
    }

    public static List<Orders> getOrdersByClientId(String username) {
        List<Orders> orders = new ArrayList<>();
        for (Orders order : orderRepository.find(ObjectFilters.eq("username", username))) {
            orders.add(order);
        }
        return orders;
    }

    public static List<Orders> getAllOrders() {
        return orderRepository.find().toList();
    }


}
