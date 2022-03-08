package com.lijunjie.tmall.controller;


import com.lijunjie.tmall.bean.Category;
import com.lijunjie.tmall.bean.Product;
import com.lijunjie.tmall.service.CategoryService;
import com.lijunjie.tmall.service.ProductService;
import com.lijunjie.tmall.utils.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @RequestMapping("admin_product_add")
    public String add(Product p) {
        p.setCreateDate(com.lijunjie.tmall.utils.Date.date());
        productService.add(p);
        return "redirect:admin_product_list.action?cid=" + p.getCategory().getId();
    }

    //已知问题：有属性值的类目下的产品不可删除，因为关联的propertyValue外键约束，对应pid
    @RequestMapping("admin_product_delete")
    public String delete(int id) {
        Product p = productService.get(id);
        productService.delete(id);
        return "redirect:admin_product_list.action?cid=" + p.getCategory().getId();
    }

    @RequestMapping("admin_product_edit")
    public String edit(Model model, int id) {
        Product p = productService.get(id);
        Category c = categoryService.get(p.getCategory().getId());
        p.setCategory(c);
        model.addAttribute("p", p);
        model.addAttribute("c", c);
        return "admin/editProduct";
    }

    @RequestMapping("admin_product_update")
    public String update(Product p) {
        productService.update(p);
        return "redirect:admin_product_list.action?cid=" + p.getCategory().getId();
    }

    @RequestMapping("admin_product_list")
    public String list(Model model, int cid, Page page){
        Category c = categoryService.get(cid);

        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Product> ps = productService.list(cid);

        int total = (int) new PageInfo<>(ps).getTotal();
        page.setTotal(total);
        page.setParam("&cid=" + cid);

        model.addAttribute("ps", ps);
        model.addAttribute("c", c);
        model.addAttribute("page", page);

        return "admin/listProduct";



    }
}