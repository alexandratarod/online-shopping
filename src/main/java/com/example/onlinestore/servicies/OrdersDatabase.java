package com.example.onlinestore.servicies;

import com.example.onlinestore.model.Orders;
import com.example.onlinestore.model.User;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.example.onlinestore.servicies.FileSystemService.getPathToFile;

public class OrdersDatabase {

    private static ObjectRepository<Orders> orderRepository;

    private static int nextOrderId = 1;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("orders.db").toFile())
                .openOrCreate("test", "test");

        orderRepository = database.getRepository(Orders.class);
    }

    public static void addOrder(Orders order) {

        order.setOrderId(nextOrderId++);
        orderRepository.insert(order);
    }

}
