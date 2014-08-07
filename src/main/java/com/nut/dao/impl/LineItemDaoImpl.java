package com.nut.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nut.dao.ILineItemDao;
import com.nut.domain.LineItem;
import com.nut.utils.Page;

@Repository
public class LineItemDaoImpl implements ILineItemDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public int addLineItem(LineItem lineItem) {
		LineItem li = (LineItem) hibernateTemplate.save(lineItem);
		return li.getId();
	}

	public void deleteLineItem(LineItem lineItem) {
		hibernateTemplate.delete(lineItem);
	}

	public void deleteLineItemById(int id) {
		LineItem lineItem = hibernateTemplate.load(LineItem.class, id);
		if(lineItem != null){
			hibernateTemplate.delete(lineItem);
		}
	}

	public void updateLineItem(LineItem lineItem) {
		hibernateTemplate.saveOrUpdate(lineItem);
	}

	public LineItem getLineItem(int id) {
		LineItem lineItem = hibernateTemplate.load(LineItem.class, id);
		return lineItem;
	}

	@SuppressWarnings("unchecked")
	public List<LineItem> getLineItems(int billId) {
		DetachedCriteria dc = DetachedCriteria.forClass(LineItem.class);
		dc.add(Restrictions.eq("bill.id", billId));
		List<LineItem> lineItems = hibernateTemplate.findByCriteria(dc);
		return lineItems;
	}

	@SuppressWarnings("unchecked")
	public long getTotalCount(int billId) {
		List<Long> size = hibernateTemplate.find("select count(*) from LineItem where bill.id=?", billId) ;
		if(size.size() > 0){
			return size.get(0);
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<LineItem> getLineItems(int billId, Page page) {
		DetachedCriteria dc = DetachedCriteria.forClass(LineItem.class);
		dc.add(Restrictions.eq("bill.id", billId));
		List<LineItem> lineItems = hibernateTemplate.findByCriteria(dc, page.getFirstResultIndex(), page.getPageSize());
		page.setCurrentPageList(lineItems);
		return lineItems;
	}

}
