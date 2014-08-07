package com.nut.service;

import java.util.List;

import com.nut.domain.Bill;

public interface IBillService {
	public int addBill(Bill bill);
	public void deleteBill(Bill bill);
	public void updateBill(Bill bill);
	public List<Bill> getBills(String userId);
	public Bill getBillById(int billId);
}
