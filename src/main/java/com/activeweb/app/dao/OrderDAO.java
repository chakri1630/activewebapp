package com.activeweb.app.dao;

import com.activeweb.app.beans.Order;

public interface OrderDAO {

	public boolean updateDeliveryAddress(Integer orderId);

	public Order getOrderDetails(Integer orderId);

	public boolean cancelOrder(Integer orderId);

}
