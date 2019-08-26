package com.niit.dao;

import com.niit.model.OrderDetail;

public interface OrderDao {

	public boolean saveOrder(OrderDetail orderDetail);
    public boolean updateCart(String username);

}
