package com.lijunjie.tmall.controller;

import com.lijunjie.tmall.bean.Admin;
import com.lijunjie.tmall.bean.Category;
import com.lijunjie.tmall.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lijunjie.tmall.utils.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_category_list")
    public String list(Model model, Page page,HttpServletRequest request) {
    	Admin admin = (Admin) request.getSession().getAttribute("admin");
    	if(admin==null) {
    		return "/admin/login";
    	}
    	System.out.println(page);
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Category> cs = categoryService.list();
        int total = (int) new PageInfo<>(cs).getTotal();
        page.setTotal(total);
        model.addAttribute("cs", cs);
        model.addAttribute("page", page);
        return "admin/listCategory";
    }

    @RequestMapping("admin_category_add")
    public String add(String name,Category category,HttpServletRequest request){
        categoryService.add(category);
        return "redirect:/admin_category_list.action";
    }

    @RequestMapping("admin_category_update")
    private String update(Category category){
        categoryService.update(category);
       
        return "redirect:/admin_category_list.action";
    }

    @RequestMapping("admin_category_delete")
    public String delete(int id){
        categoryService.delete(id);
        return "redirect:/admin_category_list.action";
    }

    @RequestMapping("admin_category_edit")
    public String edit(Model model, int id){
        Category c = categoryService.get(id);
        model.addAttribute("c", c);
        return "admin/editCategory";
    }
}
