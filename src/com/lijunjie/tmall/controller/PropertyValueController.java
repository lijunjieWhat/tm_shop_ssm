package com.lijunjie.tmall.controller;

import com.lijunjie.tmall.bean.Product;
import com.lijunjie.tmall.bean.PropertyValue;
import com.lijunjie.tmall.service.ProductService;
import com.lijunjie.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("")
public class PropertyValueController {

    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    ProductService productService;

    @RequestMapping("admin_propertyValue_edit")
    public String edit(Model model, int pid) {
        Product p = productService.get(pid);
        propertyValueService.init(p);//第一次访问时，数据库里不存在属性值，但是对应属性和产品的属性值可能是存在的，所以需要初始化
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        	System.out.println(pvs);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);

        return "admin/editPropertyValue";
    }

  
    @RequestMapping("admin_propertyValue_update")
    @ResponseBody
    public String update(PropertyValue pv) {
        propertyValueService.update(pv);
        return "success";
    }

}
