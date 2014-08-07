package com.nut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nut.service.ILineItemService;
import com.nut.utils.Page;

@Controller
public class BillController {
	
	@Autowired
	private ILineItemService lineItemService;
	
	@RequestMapping(value="/bill/listLineItems-{billId}", method=RequestMethod.GET)
	public ModelAndView listLineItems(@PathVariable Integer billId){
		
		Long totalCount = lineItemService.getTotalCount(billId);
		Page page = new Page(1, totalCount);
		lineItemService.getLineItems(billId, page);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("page", page);
		mav.setViewName("lineItem");
		return mav;
	}
	
	@RequestMapping(value="/bill", method=RequestMethod.GET)
	public String toBillList(){
		return "bill";
	}
}
