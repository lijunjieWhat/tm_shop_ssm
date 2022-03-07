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
import com.lijunjie.tmall.utils.CommonsEmail;

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
	public String search(Model m, HttpServletRequest request, String keyword) {
		List<Product> product = productService.search(keyword);
		m.addAttribute("ps", product);
		System.out.println(product);
		return "searchResult";
	}

	// 注册邮箱验证
	@RequestMapping("/registerEmailCheck")
	@ResponseBody
	public String registerEmailCheck(String email, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int pass = (int) ((Math.random() * 9 + 1) * 100000);// 随机生成验证码
		String strText = "【仿天猫项目】您的验证码是 " + pass + ",用于仿天猫网站注册，请勿将验证码透露给他人，如非本人操作，请立即联系管理员";
		CommonsEmail.sendTextMail(email, "仿天猫项目网站邮件认证", strText);
		return String.valueOf(pass);// 前端ajax接收
	}

	@RequestMapping("updatePasswordPage")
	public String GoToUpdatePasswordPage() {
		return "updatePassword";
	}
	
	@RequestMapping("updatePassword")
	public String updatePassword(User user) {
		System.out.println(user);
		userService.updateUser(user);
		return "updateSuccess";
	}
	

	// 修改密码邮箱验证
	@RequestMapping("/updatePasswordEmailCheck")
	@ResponseBody
	public String updatePasswordEmailCheck(String email, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		int pass = (int) ((Math.random() * 9 + 1) * 100000);// 随机生成验证码
		String strText = "【仿天猫项目】您的验证码是 " + pass + ",用于仿天猫账户修改密码，请勿将验证码透露给他人，如非本人操作，请立即联系管理员";
		CommonsEmail.sendTextMail(email, "仿天猫项目网站邮件认证", strText);
		return String.valueOf(pass);// 前端ajax接收
	}
	
	@RequestMapping("/quertUserByEmail")
	@ResponseBody
	public String quertUserByEmail(String email) {
		User user = userService.quertUserByEmail(email);
		if(user==null) {
			return "emailNotFound";
		}
		return user.getUsername();
	}

}
