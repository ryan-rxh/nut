package com.nut.service;

import java.util.List;

import com.nut.domain.LineItem;
import com.nut.utils.Page;

public interface ILineItemService {
	public int addLineItem(LineItem lineItem);
	public void deleteLineItem(LineItem lineItem);
	public void deleteLineItemById(int id);
	public void updateLineItem(LineItem lineItem);
	public LineItem getLineItem(int id);
	public List<LineItem> getLineItems(int billId);
	public List<LineItem> getLineItems(int billId, Page page);
	public long getTotalCount(int billId);
}
