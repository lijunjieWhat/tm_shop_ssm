package com.lijunjie.tmall.controller;

import com.lijunjie.tmall.bean.Order;
import com.lijunjie.tmall.service.OrderItemService;
import com.lijunjie.tmall.service.OrderService;
import com.lijunjie.tmall.utils.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;

    @RequestMapping("admin_order_list")
    public String list(Model model, Page page) {
        PageHelper.offsetPage(page.getStart(), page.getCount());

        List<Order> orders = orderService.list();

        int total = (int) new PageInfo<>(orders).getTotal();
        page.setTotal(total);

        orderItemService.fill(orders);
        model.addAttribute("os", orders);
        model.addAttribute("page", page);

        return "admin/listOrder";
    }

    @RequestMapping("admin_order_delivery")
    public String delivery(Order o) throws IOException {
        o.setDeliveryDate(com.lijunjie.tmall.utils.Date.date());
        o.setStatus(OrderService.waitConfirm);
        orderService.update(o);
        return "redirect:admin_order_list.action";
    }
}
