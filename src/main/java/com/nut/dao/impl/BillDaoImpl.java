package com.nut.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nut.dao.IBillDao;
import com.nut.domain.Bill;

@Repository
public class BillDaoImpl implements IBillDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	public List<Bill> getBills(String userId) {
		DetachedCriteria dc = DetachedCriteria.forClass(Bill.class);
		dc.add(Restrictions.eq("user.id", userId));
		List<Bill> bills = hibernateTemplate.findByCriteria(dc);
		return bills;
	}

	public Bill getBillById(int billId) {
		return hibernateTemplate.get(Bill.class, billId);
	}

	public int addBill(Bill bill) {
		Bill b = (Bill) hibernateTemplate.save(bill);
		return b.getId();
	}

	public void deleteBill(Bill bill) {
		hibernateTemplate.delete(bill);
	}

	public void updateBill(Bill bill) {
		hibernateTemplate.saveOrUpdate(bill);
	}
}
