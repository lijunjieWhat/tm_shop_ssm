# tm_shop_ssm

具体请看上传的项目文档




《Java Web》大作业

   题    目：          仿天猫商城          
   指导教师：             董荷飞                   
  专    业：   计算机科学与技术         
  院    系：   信 息 技 术 学 院             
  完成时间：   2020 年 12 月 27日                   
 
第一章 需求分析
1.1 应用功能
1、应用简介
此项目用SSM框架实现模仿天猫网站的各种业务场景.首先作为购物网站，由前台和后台组成。前台主要针对用户购物，后台主要针对管理员对商品以及订单管理。前台部分主要要求实现用户可以在网站进行便捷的购物，可以查看到发布的所有的商品信息和对应的评论信息，项目基本功能已经完善，用户可以把自己喜欢的物品加入购物车，查看自己的订单以及搜索自己喜欢的商品，经过下单的订单将分为多个状态，待付款，待发货，待收货等。后台管理员对类别，商品，订单，用户进行管理。可以简便的添加类别，发布商品，对用户的订单进行查看，发货等等操作，极大的方便了人们的购物，节约用户时间，节约商家成本。
用到的技术如下：
Java：javaWeb基础
前端：HTML、CSS、JavaScript、jQuery、ajax、bootstrap。
服务器：Tomcat
框架：springmvc、spring、mybatis。
数据库：mysql
2、应用功能
前台包括用户注册，登陆，商品的展示（首页的展示），商品详细的细节展示（打开某一商品时的显示），购物车模块，订单模块，商品的评论以及模糊查询。后台部分主要是分类管理（添加类别：如手机，冰箱，零食），产品管理（对产品的增删改查），属性管理（如物品的颜色，重量），商品图片管理（分为产品图和商品详细图），用户管理和订单管理（订单的查看，以及发货操作）。
整个应用的功能结构图如图下图所示：
 
 ![image](https://user-images.githubusercontent.com/46127608/157229052-a5c4a1cc-841c-4de3-9d30-4d4c9653eec2.png)




1.2 程序流程图
用户使用购物功能的程序流程图如下图所示：

![image](https://user-images.githubusercontent.com/46127608/157229081-148ceeef-5b3c-4049-a441-c2b73d401734.png)


管理员发货程序流程图如下图所示：
 

用户对订单进行收货：

 
第二章 总体设计
2.1 应用模块设计
有哪些模块，每个模块的功能。

2.2 数据库表设计
数据库包含哪些表，设计思路。

表名	中文含义	介绍
Category	分类表 	存放分类信息，手机，冰箱等
Property	属性表 	存放属性信息，如颜色，重量，品牌，厂商，型号等
Product	产品表 	存放产品信息，如华为mate40，苹果12
PropertyValue	属性值表 	存放属性值信息，如重量是900g,颜色是白色
ProductImage	产品图片表 	存放产品图片信息，如产品页显示的5个图片
Review	评论表 	存放评论信息
User	用户表 	存放用户信息
Order	订单表 	存放订单信息，包括邮寄地址，电话号码等信息
OrderItem	订单项表 	存放订单项信息，包括购买产品种类，数量，总价等 


Admin(管理员表)
列名	类型	描述	主键	空值
Id	String	管理员 ID	是	否
name	String	用户名	否	否
password	String	密码	否	否
 



类别表（category）
列名	类型	描述	主键	空值
Id	String	类别 ID	是	否
name	String	类别名	否	否
 


订单表（order_）
列名	类型	描述	主键	空值
Id	int	订单 ID	是	否
orderCode	String	订单编号	否	否
address	String	收货地址	否	否
post	String	邮编	否	否
receiver	String	收货人	否	否
mobile	String	手机号	否	否
userMessage	String	买家留言	否	否
createDate	String	下单日期	否	否
payDate	String	支付日期	否	否
deliveryDate	String	运输日期	否	否
confirmDate	String	确认收货日期	否	否
status	String	订单状态	否	否

orderItem（订单详情表）

列名	类型	描述	主键	空值
Id	int	订单项 ID	是	否
pid	int	产品id	否	否
oid	int	订单id	否	否
number	int	产品总数	否	否

Product（产品表）

列名	类型	描述	主键	空值
Id	int	产品 ID	是	否
name	String	产品编号	否	否
subTitle	String	产品小标题	否	否
originalPrice	String	原价	否	否
promotePrice	String	促销价	否	否
stock	String	库存	否	否
cid	String	类别id	否	否
createDate	String	创建日期	否	否



Productimage（产品图片表）
列名	类型	描述	主键	空值
Id	int	产品图片 ID	是	否
pid	int	产品图片编号	否	否
type	String	类型	否	否

Property（属性表）
列名	类型	描述	主键	空值
Id	int	属性 ID	是	否
cid	int	分类id	否	否
Name	String	属性名字	否	否
Propertyvalue（属性值表）

列名	类型	描述	主键	空值
Id	int	 ID	是	否
Pid	int	产品id	否	否
ptid	int	属性id	否	否
value	String	属性值	否	否






Review（评论表）
列名	类型	描述	主键	空值
Id	int	 ID	是	否
content	String	评论内容	否	否
uid	int	用户id	否	否
pid	int	产品id	否	否
createDate	String	日期	否	否
User(用户表简化)
列名	类型	描述	主键	空值
Id	int	 ID	是	否
username	String	用户名	否	否
password	String	密码	否	否


2.3表关系
 
一	多
Category-分类	Product-产品
Category-分类	Property-属性
Property-属性	PropertyValue-属性值
Product-产品	PropertyValue-属性值
Product-产品	ProductImage-产品图片
Product-产品	Review-评价
User-用户	Order-订单
Product-产品	OrderItem-订单项 
User-用户	OrderItem-订单项
Order-订单	OrderItem-订单项
User-用户	User-评价


第三章 编码实现
3.1 界面截图
  首页
 
 

产品详情页
 

 
评价页
 
注册页
 
登陆页
 
购物车页
 
提交订单页
 

支付页
 
支付完成页
 
订单页
 
 
确认收货页
 
收货完成页
 
评论页
 
 
搜索页
 

修改密码页
 
3.2 部分代码展示
package com.lijunjie.tmall.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lijunjie.tmall.bean.Category;
import com.lijunjie.tmall.bean.Order;
import com.lijunjie.tmall.bean.OrderItem;
import com.lijunjie.tmall.bean.Product;
import com.lijunjie.tmall.bean.Review;
import com.lijunjie.tmall.bean.User;
import com.lijunjie.tmall.dao.PropertyValueMapper;
import com.lijunjie.tmall.service.CategoryService;
import com.lijunjie.tmall.service.OrderItemService;
import com.lijunjie.tmall.service.OrderService;
import com.lijunjie.tmall.service.ProductService;
import com.lijunjie.tmall.service.PropertyValueService;
import com.lijunjie.tmall.service.ReviewService;
import com.lijunjie.tmall.service.UserService;

/**
 * 前台
 * 
 * @author 李俊杰
 *
 */
@Controller
@RequestMapping("fore")
public class ForeController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;
    @Autowired
    private PropertyValueService propertyValueService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ReviewService reviewService;

    /**
     * 首页
     * 
     * @param m
     * @return
     */
    @RequestMapping("home")
    public String index(Model m, HttpServletRequest request) {
        List<Category> categories = categoryService.queryAllCategories();
        m.addAttribute("categories", categories);
        User user = (User) request.getSession().getAttribute("user");
        Integer cartTotalItemNumber = 0;
        if (user != null) {
            cartTotalItemNumber = orderItemService.queryCartProductNumber(user);
        }
        request.getSession().setAttribute("cartTotalItemNumber", cartTotalItemNumber);
        return "home";
    }

    /**
     * 产品详细页
     * 
     * @param pid
     * @param m
     * @return
     */
    @RequestMapping("product")
    public String productDetail(Integer pid, Model m) {
        Product product = productService.queryProductById(pid);

        List<PropertyValueMapper> propertValue = propertyValueService.queryPropertValue(pid);
        m.addAttribute("p", product);
        m.addAttribute("pvs", propertValue);
        return "product";
    }

    @RequestMapping("registerPage")
    public String GoToregisterPage() {
        return "register";
    }

    @RequestMapping("checkUserName")
    @ResponseBody
    public Integer checkUserName(String username) {
        Integer flag = 0;
        User user = userService.checkUserName(username);
        if (user != null) {
            flag = 1;
        }
        return flag; // 0可以注册
    }

    @RequestMapping("register")
    public String register(User user, HttpServletRequest request) {
        user.setCreateDate(com.lijunjie.tmall.utils.Date.date());
        Integer userRegister = userService.userRegister(user);
        System.out.println(user);
        User user2 = userService.queryUserByUid(user.getId());
        request.getSession().setAttribute("user", user2);
        return "registerSuccess";
    }

    @RequestMapping("loginPage")
    public String GoTologinPage() {
        return "login";
    }

    @RequestMapping("login")
    public String login(User user, HttpServletRequest request) {
        User user2 = userService.queryUserByUserNameAndPassword(user);
        if (user2 == null) {
            request.setAttribute("msg", "账号密码错误");
            return "login";
        }
        Integer cartTotalItemNumber = orderItemService.queryCartProductNumber(user);
        request.getSession().setAttribute("cartTotalItemNumber", cartTotalItemNumber);
        request.getSession().setAttribute("user", user2);
        return "redirect:/fore/home.action";
    }

    @RequestMapping("loginOut")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "redirect:/fore/home.action";
    }

    @RequestMapping("checkLogin")
    @ResponseBody
    public String checkLogin(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (null != user)
            return "success";
        return "fail";
    }

    @RequestMapping("loginAjax")
    @ResponseBody
    public String loginAjax(HttpServletRequest request, User user) {

        User user2 = userService.queryUserByUserNameAndPassword(user);

        if (null == user2) {
            return "fail";
        }
        request.getSession().setAttribute("user", user2);
        return "success";
    }

    @RequestMapping("addCart")
    @ResponseBody
    public String addCart(HttpServletRequest request, OrderItem orderItem) {
        User user = (User) request.getSession().getAttribute("user");
        orderItem.setUser(user);
        OrderItem item = orderItemService.queryCartProductByPidAndUid(orderItem.getProduct().getId(),
                orderItem.getUser().getId());
        if (item == null) {
            orderItemService.addCart(orderItem);
        } else {
            orderItem.setNumber(orderItem.getNumber() + item.getNumber());
            orderItemService.updateInCartProductNumber(orderItem);
        }
        return "success";
    }

    @RequestMapping("getCartTotalNumber")
    @ResponseBody
    public Integer getCartTotalNumber(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Integer cartTotalItemNumber = orderItemService.queryCartProductNumber(user);
        request.getSession().setAttribute("cartTotalItemNumber", cartTotalItemNumber);
        return cartTotalItemNumber;
    }

    @RequestMapping("cart")
    public String GoToCartPage(HttpServletRequest request, Model m) {
        User user = (User) request.getSession().getAttribute("user");
        List<OrderItem> carts = orderItemService.queryCartByUid(user.getId());
        m.addAttribute("orderItems", carts);
        return "cart";
    }

    @RequestMapping("changeOrderItem")
    @ResponseBody
    public Integer changeOrderItem(HttpServletRequest request, OrderItem orderItem, Model m) {
        User user = (User) request.getSession().getAttribute("user");
        orderItem.setUser(user);
        orderItemService.updateInCartProductNumber(orderItem);
        Integer cartTotalItemNumber = orderItemService.queryCartProductNumber(user);
        return cartTotalItemNumber;
    }

    @RequestMapping("orderConfrim")
    public String orderConfrim(String num, String pid, Model m, String[] orderItem, HttpServletRequest request,
            HttpServletResponse response) {
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        float total = 0;
        if (pid != null) {
            OrderItem item = new OrderItem();
            Product product = productService.queryProductById(Integer.parseInt(pid));
            item.setProduct(product);
            item.setNumber(Integer.parseInt(num));
            orderItems.add(item);
            total = item.getProduct().getPromotePrice() * Integer.parseInt(num);
        } else {
            for (int i = 0; i < orderItem.length; i++) {
                OrderItem item = orderItemService.queryOrderItemByOIid(Integer.parseInt(orderItem[i]));
                total += item.getProduct().getPromotePrice() * item.getNumber();
                orderItems.add(item);
            }
        }

        request.getSession().setAttribute("orderItems", orderItems);
        request.getSession().setAttribute("total", total);

        // m.addAttribute("orderItems", orderItems);
        // m.addAttribute("total", total);
        return "forward:/fore/buyPage.action";
    }

    @RequestMapping("buyPage")
    public String ToBuyPage() {
        return "buy";
    }

    @RequestMapping("createOrder")
    public String createOrder(Order order, HttpServletRequest request, String status) {
        User user = (User) request.getSession().getAttribute("user");
        Float total = (Float) request.getSession().getAttribute("total");
        List<OrderItem> orderItems = (List<OrderItem>) request.getSession().getAttribute("orderItems");
        order.setUser(user);
        order.setOrderCode(String.valueOf(UUID.randomUUID()));
        order.setCreateDate(com.lijunjie.tmall.utils.Date.date());
        order.setStatus(OrderService.waitPay);
        order.setOrderItems(orderItems);
        order.setTotal(total);
        orderService.addOrder(order);
        // 从购物车进入,，要将oid修改为当前订单id
        if (status == null || status == "") {
            for (OrderItem orderItem : orderItems) {
                orderItem.setOrder(order);
                orderItemService.updateOid(orderItem);
            }
        } else {// 直接从商品购买页面跳入，直接向orderitem插入数据
            for (OrderItem orderItem : orderItems) {
                orderItem.setOrder(order);
                orderItemService.addOrderitem(orderItem);
            }
        }
        Integer cartTotalItemNumber = orderItemService.queryCartProductNumber(user);
        request.getSession().setAttribute("cartTotalItemNumber", cartTotalItemNumber);
        return "forward:/fore/alipayPage.action?oid=" + order.getId();
    }

    @RequestMapping("alipayPage")
    public String Toalipay(HttpServletRequest request, HttpServletResponse response) {

        return "alipay";
    }

    @RequestMapping("payed")
    public String payed(HttpServletRequest request, String oid) {
        Order order = new Order();
        order.setId(Integer.parseInt(oid));
        order.setPayDate(com.lijunjie.tmall.utils.Date.date());
        order.setStatus(OrderService.waitDelivery);
        orderService.update(order);
        return "payed";
    }

    @RequestMapping("bought")
    public String bought(HttpServletRequest request, Model m) {
        User user = (User) request.getSession().getAttribute("user");
        List<Order> userAllOrders = orderService.queryUserAllOrders(user, OrderService.delete);

        m.addAttribute("os", userAllOrders);
        return "bought";

    }

    @RequestMapping("confirmPay")
    public String confirmPay(HttpServletRequest request, String oid, Model m) {
        Order order = orderService.queryOrderByOid(Integer.parseInt(oid));
        m.addAttribute("o", order);

        return "confirmPay";
    }

    @RequestMapping("orderConfirmed")
    public String orderConfirmed(HttpServletRequest request, String oid) {
        Order order = new Order();
        order.setId(Integer.parseInt(oid));
        order.setConfirmDate(com.lijunjie.tmall.utils.Date.date());
        order.setStatus(OrderService.waitReview);
        orderService.update(order);
        return "orderConfirmed";
    }

    @RequestMapping("review")
    public String review(HttpServletRequest request, String oid, Model m) {
        Order order = orderService.queryOrderByOid(Integer.parseInt(oid));

        Product product = order.getOrderItems().get(0).getProduct();
        product.setReviewCount(product.getReviews().size());
        product.setSaleCount(100000);
        m.addAttribute("o", order);
        m.addAttribute("p", product);
        return "review";
    }

    @RequestMapping("doreview")
    public String doreview(HttpServletRequest request, Review review, String oid) {
        User user = (User) request.getSession().getAttribute("user");
        review.setUser(user);
        review.setCreateDate(com.lijunjie.tmall.utils.Date.date());
        reviewService.addReview(review);
        return "redirect:/fore/review.action?oid=" + oid;
    }

    @RequestMapping("deleteOrder")
    @ResponseBody
    public String deleteOrder(HttpServletRequest request, String oid) {
        Order order = new Order();
        order.setId(Integer.parseInt(oid));
        order.setConfirmDate(com.lijunjie.tmall.utils.Date.date());
        order.setStatus(OrderService.delete);
        orderService.update(order);
        return "success";
    }

    @RequestMapping("category")
    public String category(Model m, HttpServletRequest request, String cid) {
        List<Category> categories = categoryService.queryAllCategories();
        for (Category category : categories) {
            if (category.getId() == Integer.parseInt(cid)) {
                m.addAttribute("category", category);
                break;
            }
        }
        return "category";
    }

    @RequestMapping("search")
    public String search(Model m,HttpServletRequest request, String keyword) {
        List<Product> product = productService.search(keyword);
        m.addAttribute("ps", product);
        System.out.println(product);
        return "searchResult";
    }
}



第四章 总结与展望
此项目使让我学会了熟练运用SSM框架，用一整套相对健全的技术开发此项目，有很大的进步以及也有少许成就感。后期还是继续优化此项目，包括加入Redis缓存来提高效率，会改成springboot开发以及后台加上权限管理，继续优化项目，尽量做成一个健全的项目用来学习研究。
