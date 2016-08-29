package com.meybosoft.microerp.business;

import java.util.Date;

import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.domain.Customer;
import com.meybosoft.microerp.domain.Product;
import com.meybosoft.microerp.domain.WaterTicket;

public interface WaterTicketService {
WaterTicket getWaterTicket(Long id);
WaterTicket getWaterTicketBySn(Product product,Long sn);
//判断某一种类型的水票编号是否存在
boolean validateWater(Product product,int begin,int end);
boolean addWaterTicket(WaterTicket ticket);
boolean delWaterTicket(WaterTicket ticket);
IPageList queryWaterTicket(String scope, java.util.Collection paras, int currentPage,
			int pageSize);
boolean reclaim(Product product,Long sn,Date backDate,Customer consumer);
}
