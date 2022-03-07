package com.lijunjie.tmall.controller;

import com.lijunjie.tmall.bean.Category;
import com.lijunjie.tmall.bean.Property;
import com.lijunjie.tmall.service.CategoryService;
import com.lijunjie.tmall.service.PropertyService;
import com.lijunjie.tmall.utils.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class PropertyController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    PropertyService propertyService;

    @RequestMapping("admin_property_add")
    public String add(Model model, Property p) {
        propertyService.add(p);
        return "redirect:admin_property_list.action?cid=" + p.getCategory().getId();
    }

    @RequestMapping("admin_property_delete")
    public String delete(int id) {
        Property p = propertyService.get(id);
        propertyService.delete(id);
        return "redirect:admin_property_list.action?cid=" + p.getCategory().getId();
    }

    @RequestMapping("admin_property_edit")
    public String  edit(Model model, int id) {
        Property p = propertyService.get(id);
        Category c = categoryService.get(p.getCategory().getId());//跳转到编辑页面，编辑好了之后需要跳转到对应的Category的Property列表,到时候需要知道Property的category属性
        p.setCategory(c);//property对象时从数据库get的，其没有category字段，所以需要自己手动获取，并赋值给property
        model.addAttribute("p", p);
        return "admin/editProperty";
    }

    @RequestMapping("admin_property_update")
    public String update(Property p) {
        propertyService.update(p);//更新操作只需要cid和name字段，这两个字段对应editProperty.jsp里面的表单
        return "redirect:admin_property_list.action?cid=" + p.getCategory().getId();
    }

    @RequestMapping("admin_property_list")
    public String list(int cid, Model model, Page page){
        Category c = categoryService.get(cid);
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Property> ps = propertyService.list(cid);

        int total = (int) new PageInfo<>(ps).getTotal();
        page.setTotal(total);
        page.setParam("&cid=" + c.getId());
        model.addAttribute("ps", ps);
        model.addAttribute("c", c);
        model.addAttribute("page", page);
     
        return "admin/listProperty";

    }
}
