package com.meybosoft.microerp.business;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.domain.Delivery;
import com.meybosoft.microerp.domain.DeliveryDetail;

public interface DeliveryService {
Delivery getDelivery(Long id);
boolean addDelivery(Delivery delivery);
boolean updateDelivery(Delivery delivery);
boolean delDelivery(Delivery delivery);
Delivery getLastDelivery();

IPageList queryDelivery(String scope, java.util.Collection paras, int currentPage,
			int pageSize);

boolean addDeliveryDetail(DeliveryDetail detail);
boolean updateDeliverDetail(DeliveryDetail detail);
boolean delDeliveryDetail(DeliveryDetail detail);

//派选定的定定单
boolean appointOrder(Delivery delivery,Long orderId,String intro);

}
