package com.nut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nut.dao.ILineItemDao;
import com.nut.domain.LineItem;
import com.nut.service.ILineItemService;
import com.nut.utils.Page;

@Service("lineItemService")
public class LineItemServiceImpl implements ILineItemService {
	@Autowired
	private ILineItemDao lineItemDao;

	public int addLineItem(LineItem lineItem) {
		return lineItemDao.addLineItem(lineItem);
	}

	public void deleteLineItem(LineItem lineItem) {
		lineItemDao.deleteLineItem(lineItem);;
	}

	public void deleteLineItemById(int id) {
		lineItemDao.deleteLineItemById(id);;
	}

	public void updateLineItem(LineItem lineItem) {
		lineItemDao.updateLineItem(lineItem);;
	}

	public LineItem getLineItem(int id) {
		return lineItemDao.getLineItem(id);
	}

	public List<LineItem> getLineItems(int billId) {
		return lineItemDao.getLineItems(billId);
	}

	public long getTotalCount(int billId) {
		return lineItemDao.getTotalCount(billId);
	}

	public List<LineItem> getLineItems(int billId, Page page) {
		return lineItemDao.getLineItems(billId, page);
	}
}
