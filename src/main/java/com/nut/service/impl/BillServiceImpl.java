package com.nut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nut.dao.IBillDao;
import com.nut.domain.Bill;
import com.nut.service.IBillService;

@Service("billService")
public class BillServiceImpl implements IBillService {

	@Autowired
	private IBillDao billDao;
	
	public int addBill(Bill bill) {
		return billDao.addBill(bill);
	}

	public void deleteBill(Bill bill) {
		billDao.deleteBill(bill);;
	}

	public void updateBill(Bill bill) {
		billDao.updateBill(bill);
	}

	public List<Bill> getBills(String userId) {
		return billDao.getBills(userId);
	}

	public Bill getBillById(int billId) {
		return billDao.getBillById(billId);
	}

}
