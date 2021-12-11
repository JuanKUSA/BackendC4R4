/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Catalogo_CangrejoWeb.CatalogoCangrejoWeb.servicio;

import Catalogo_CangrejoWeb.CatalogoCangrejoWeb.modelo.Order;
import Catalogo_CangrejoWeb.CatalogoCangrejoWeb.repositorio.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Valero
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepositorio;

    public List<Order> getAll() {
        return orderRepositorio.getAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepositorio.getOrder(id);
    }

    public Order create(Order order) {

        Optional<Order> orderIdMaxima = orderRepositorio.lastUserId();

        if (order.getId() == null) {
                if (orderIdMaxima.isEmpty())
                order.setId(1);
                else
                order.setId(orderIdMaxima.get().getId() + 1);
        }
        Optional<Order> e = orderRepositorio.getOrder(order.getId());
        if (e.isEmpty()) {
            return orderRepositorio.create(order);
        }else{
            return order;
        }
    }

    public Order update(Order order) {

        if (order.getId() != null) {
            Optional<Order> orderDb = orderRepositorio.getOrder(order.getId());
            if (!orderDb.isEmpty()) {
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                orderRepositorio.update(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getOrder(id).map(order -> {
            orderRepositorio.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Order> findByZone(String zone) {
        return orderRepositorio.findByZone(zone);
    }
    
    //Métodos del reto 4
    //Reto 4: Ordenes de un asesor
    public List<Order> ordersSalesManByID(Integer id){
        return orderRepositorio.ordersSalesManByID(id);
    }
    //Reto 4: Ordenes de un asesor x Estado
    public List<Order> ordersSalesManByState(String state, Integer id){
        return orderRepositorio.ordersSalesManByState(state, id);
    }
    //Reto 4: Ordenes de un asesor x fecha
    public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
        return orderRepositorio.ordersSalesManByDate(dateStr,id);
    }
}