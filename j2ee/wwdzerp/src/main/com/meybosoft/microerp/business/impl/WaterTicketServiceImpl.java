package com.meybosoft.microerp.business.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.easyjf.web.tools.DbPageList;
import com.easyjf.web.tools.IPageList;
import com.meybosoft.microerp.business.CustomerService;
import com.meybosoft.microerp.business.LogicException;
import com.meybosoft.microerp.business.WaterTicketService;
import com.meybosoft.microerp.domain.Customer;
import com.meybosoft.microerp.domain.Product;
import com.meybosoft.microerp.domain.WaterTicket;

public class WaterTicketServiceImpl extends AbstractDAOServiceSupport implements
		WaterTicketService {
	private CustomerService customerService;
	public boolean addWaterTicket(WaterTicket ticket) {		
		boolean ret=this.dao.save(ticket);
		/*
		Customer cu=ticket.getCustomer();
		if(ret)
		{
			cu.setTicketNum(cu.getTicketNum()==null?1:cu.getTicketNum()+1);
			customerService.updateCustomer(cu);
		}*/
		return ret;
	}

	public boolean delWaterTicket(WaterTicket ticket) {	
		boolean ret=this.dao.del(ticket);
		Customer cu=ticket.getCustomer();
		if(ret&& cu.getTicketNum()!=null &&cu.getTicketNum()>0)
		{
			cu.setTicketNum(cu.getTicketNum()-1);
			customerService.updateCustomer(cu);
		}
		return ret;
	}

	public WaterTicket getWaterTicket(Long id) {		
		return (WaterTicket)this.dao.get(WaterTicket.class, id);
	}

	public WaterTicket getWaterTicketBySn(Product product,Long sn) {
		List list=this.dao.query(WaterTicket.class,"sn="+sn+" and product_id="+product.getId());
		if(list!=null && list.size()>0)return (WaterTicket)list.get(0);
		else return null;
	}

	public IPageList queryWaterTicket(String scope, Collection paras,
			int currentPage, int pageSize) {
		DbPageList pageList=new DbPageList(WaterTicket.class,scope,paras,dao);
		pageList.doList(currentPage, pageSize);	
		return pageList;
	}

	public boolean validateWater(Product product,int begin, int end) {
		List list=this.dao.query(WaterTicket.class,"product_id="+product.getId()+" and sn>="+begin+" and sn<="+end);
		if(list!=null && list.size()>0)
		{
			String s="以下编号已经被占用：";
			for(int i=0;i<list.size();i++)
			{
				s+=((WaterTicket)list.get(i)).getSn()+",";				
			}
			throw new LogicException(s);
		}
		return true;
	}

	public boolean reclaim(Product product,Long sn, Date backDate, Customer consumer) {
		WaterTicket wt=getWaterTicketBySn(product,sn);
		if(wt==null)throw new LogicException("该编号的水票不存在！");
		if(wt.getStatus()!=null && wt.getStatus().intValue()==2)throw new LogicException("该水票已经回收过，不能重复回收！");
		wt.setBackDate(backDate);
		wt.setStatus(new Integer(2));
		wt.setConsumer(consumer);		
		boolean ret=this.dao.update(wt);
		if(ret){
			Customer cu=wt.getCustomer();
			if(cu.getTicketNum()!=null && cu.getTicketNum()>0)cu.setTicketNum(cu.getTicketNum()-1);
			customerService.updateCustomer(cu);
		}
			return ret;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
}
