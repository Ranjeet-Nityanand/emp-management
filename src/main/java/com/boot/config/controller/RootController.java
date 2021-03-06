package com.boot.config.controller;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.boot.config.dto.CartDTO;
import com.boot.config.dto.DTODomainConverter;
import com.boot.config.dto.RegisterDTO;
import com.boot.config.service.IUserService;

import login.CartDomain;
import login.Product;
import login.User;

@Controller
public class RootController {
	@Autowired
	IUserService iUserService;
	@Autowired
	Environment env;
	List<User> allemployee;
	List<Product> allproduct;
	@Value("${UPLOADED_FOLDER}")
	private String uploadDirectory;
	@Autowired
	ServletContext context;

	@RequestMapping("/")
	public ModelAndView indexController() {
		ModelAndView view = new ModelAndView();
		view.setViewName("view/index");
		return view;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView indexController(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		ModelAndView view = new ModelAndView();

		if (email != null && password != null) {
			User login = new User();
			login.setEmail(email);
			login.setPassword(password);
			User user1 = iUserService.validateUser(login);
			if (user1 != null) {
				if (user1.getRoll_id() == 1) {
					view.addObject("ranjeet", user1);
					view.setViewName("view/adminprofile");
				}
				if (user1.getRoll_id() == 2) {
					view.addObject("ranjeet", user1);
					view.setViewName("view/userprofile");

				}
				if (user1.getRoll_id() == 3) {
					view.addObject("user", user1);
					Product product = new Product();
					List<Product> allproduct = iUserService.getAllProduct(product);
					view.addObject("allitem", allproduct);
					view.setViewName("view/shoping");
				}

			} else {
				view.addObject("message", "Wrong Entry!!!!!");
				view.setViewName("view/index");
			}

		} else {
			view.addObject("message", "Username or Password Cannot be blank!!!");
			// view.setViewName("redirect:/");
			view.setViewName("view/index");
		}

		return view;
	}

	// ===Sudhir====//
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(RegisterDTO adduser) {
		System.err.println("user name====" + adduser.getName());
		ModelAndView view = new ModelAndView();
		User register = new User();

		register = DTODomainConverter.convertRegiterDTOToDomain(adduser);
		System.err.println("Root in Register Domain--------------"+register);
		User dbuser = iUserService.addUser(register);
//		RegisterDTO userprofile = new RegisterDTO();
//		userprofile = DTODomainConverter.convertDomainToRegisterDTO(dbuser);
		/* int emailcount = */iUserService.validateRegister(register);

		view.addObject("register", dbuser);

		if (dbuser != null) {
			System.err.println("After Insert In DB Controller :" + dbuser.getDob() + "" + dbuser.getGender());

			view.setViewName("view/userprofile");
		} else {
			view.addObject("message1", "Email allready exits");
			view.setViewName("view/index");
			// view.setViewName("redirect:/");
		}

		return view;
	}

	@RequestMapping("/viewallEmployee")
	public ModelAndView allUser() {
		ModelAndView view = new ModelAndView();
		User user = new User();
		List<User> allemployee = iUserService.getAllEmployee(user);
		System.err.println(allemployee.isEmpty());
		view.addObject("allUser", allemployee);
		System.err.println("Testing");
		view.setViewName("view/viewallemployee");
		return view;
	}

	@RequestMapping("/viewallEmployee1")
	public ModelAndView allUser1() {
		ModelAndView view = new ModelAndView();
		User user = new User();
		List<User> allemployee = iUserService.getAllEmployee(user);
		System.err.println(allemployee.isEmpty());
		view.addObject("allUser", allemployee);
		System.err.println("Testing");
		view.setViewName("view/viewallemployee1");
		return view;
	}
	@RequestMapping(value = "/update-emp-status", method = RequestMethod.GET)
	@ResponseBody // return data as json Formate
	public List<User> updateemployeeStatus(@RequestParam("id") int id,
			@RequestParam("status") Integer status) {
		User user2 = new User();
		user2.setId(id);
		user2.setStatus_id(status);
		System.err.println("value=" + user2.getId() + "==" + user2.getStatus_id());
		List<User> alluser1 = iUserService.updateemployeeStatus(user2);
		System.err.println("Length ----" + alluser1.size());
		return alluser1;
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
	public ModelAndView editEmployee(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("contact") String contact, @RequestParam("address") String address,
			@RequestParam("role") String role, @RequestParam("id") String id) {
		ModelAndView view = new ModelAndView();

		User register = new User();
		register.setName(name);
		register.setEmail(email);
		register.setAddress(address);
		register.setContact(contact);
		try {
			register.setRoll_id(Integer.parseInt(role));
			register.setId(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.err.println("Getting Id from view all user" + id);
		List<User> dbuser = iUserService.editEmployee(register);
		// System.err.println("Retrieve from Service" + dbuser);
		if (dbuser != null) {
			User viewemp = new User();
			allemployee = iUserService.getAllEmployee(viewemp);
			System.err.println(allemployee.isEmpty());
			view.addObject("allUser", allemployee);
			view.addObject("successmsg", "Updation Successfull");
			view.setViewName("view/viewallemployee");
		} else {
			view.addObject("allUser", allemployee);
			view.addObject("message1", "Updation uncessfull");
			view.setViewName("view/viewallemployee");
		}
		return view;
	}

	@RequestMapping("/add-employee")
	public ModelAndView addEmployee() {
		ModelAndView view = new ModelAndView();
		view.setViewName("view/addemployee");
		return view;
	}

	@RequestMapping(value = "/addemployee", method = RequestMethod.POST)
	public ModelAndView editEmployee(@RequestParam("status") String statusid, @RequestParam("role") String roleid,
			@RequestParam("id") String empid, @RequestParam("email") String email, @RequestParam("name") String name,
			@RequestParam("contact") String contact, @RequestParam("password") String password,
			@RequestParam("dob") String dob, @RequestParam("address") String address,
			@RequestParam("gender") String gender) {
		ModelAndView view = new ModelAndView();
		System.err.println("Add User ------------------------");
		User addemp = new User();
		addemp.setName(name);
		addemp.setEmail(email);
		addemp.setDob(dob);
		addemp.setAddress(address);
		addemp.setGender(gender);
		addemp.setPassword(password);
		addemp.setContact(contact);
		addemp.setEmp_id(empid);
		try {
			addemp.setRoll_id(Integer.parseInt(roleid));
			addemp.setStatus_id(Integer.parseInt(statusid));
		} catch (Exception e) {
			e.printStackTrace();
		}
		int count = iUserService.validateEmployee(addemp);
		if (count == 0) {
		List<User> employee = iUserService.addEmployee(addemp);
		if (employee != null) {
			User viewemp = new User();
			allemployee = iUserService.getAllEmployee(viewemp);
			System.err.println(allemployee.isEmpty());
			view.addObject("allUser", allemployee);
			view.addObject("successmsg", "Added Successfull");
			view.setViewName("view/viewallemployee");

		} else {
			view.addObject("allUser", allemployee);
				view.addObject("message1", "!!! Record not added");
			view.setViewName("view/viewallemployee");
		}
		} else {
			view.addObject("message1", " Employee Already Registered");
			view.setViewName("view/adminprofile");
		}
		return view;
	}

	@RequestMapping("/add-product")
	public ModelAndView addProduct() {
		ModelAndView view = new ModelAndView();
		view.setViewName("view/addproduct");
		return view;
	}

	@RequestMapping("/viewallProduct")
	public ModelAndView allProduct() {
		ModelAndView view = new ModelAndView();
		Product product = new Product();
		List<Product> allproduct = iUserService.getAllProduct(product);
		System.err.println(allproduct.isEmpty());
		view.addObject("allUser", allproduct);
		System.err.println(allproduct);
		view.setViewName("view/viewallproduct");
		return view;
	}

	@RequestMapping(value = "/editProduct", method = RequestMethod.POST)
	public ModelAndView editProduct(@RequestParam("name") String productname,
			@RequestParam("price") String productprice, @RequestParam("quantity") String quantity,
			@RequestParam("id") int prodid) {
		ModelAndView view = new ModelAndView();

		Product editprod = new Product();
		editprod.setName(productname);
		editprod.setId(prodid);
		try {
			editprod.setQuantity(Integer.parseInt(quantity));
			editprod.setPrice(Float.parseFloat(productprice));
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Product> prod = iUserService.editProduct(editprod);
		if (prod != null) {
			System.err.println("Edited product ================" + prod);
			Product viewprod = new Product();
			allproduct = iUserService.getAllProduct(viewprod);
			System.err.println(allproduct.isEmpty());
			view.addObject("allUser", allproduct);
			view.addObject("successmsg", "Updation Successfull");
			view.setViewName("redirect:viewallProduct");
		} else {
			view.addObject("allUser", allproduct);
			view.addObject("message1", "Updation uncessfull");
			view.setViewName("redirect:viewallProduct");
		}
		return view;
	}

	// Add Product Using DTO Class....

//	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
//	public RedirectView addProduct(ProductDTO prd, RedirectAttributes attributes) {
//		Product addproduct = new Product();
//		// Converting DTO Values toDomain........
//		addproduct = DTODomainConverter.convertProductDTOToDomain(prd);
//		List<Product> productlist = iUserService.addProduct(addproduct);
//		List<ProductDTO> proddtolist = new ArrayList<>();
//		for (Product product2 : productlist) {
//			proddtolist.add(DTODomainConverter.convertProductDomainToDTO(product2));
//
//		}
//		System.err.println("Final data after converting Domain to DTO" + proddtolist);
//		if (productlist != null) {
//			Product viewproduct = new Product();
//			allproduct = iUserService.getAllProduct(viewproduct);
//			System.err.println(allproduct.isEmpty());
//			attributes.addFlashAttribute("message", "Inserted Successfully");
//			return new RedirectView("viewallProduct");
//		} else {
//			attributes.addFlashAttribute("message", "Not Inserted");
//			// view.setViewName("redirect:viewallProduct");
//			return new RedirectView("viewallProduct");
//
//		}
//
//	}
	
	Path path,path1;
	//private static String UPLOADED_FOLDER = "E:/videos/java/";
	static int c=0;
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public RedirectView addProduct(@RequestParam("name") String productname, @RequestParam("price") Float productprice,
			@RequestParam("quantity") int quantity, @RequestParam("file") MultipartFile file,
			RedirectAttributes attributes) {
		
		try {
//			File original=new File(env.getProperty("UPLOADED_FOLDER")+file.getOriginalFilename());
//			File dir=original.getParentFile();
//			File result=new File(dir,"myfile.jpg");
//			System.err.println("Original File path inside the file-------------------->"+original);

			Long l=System.currentTimeMillis();
			byte[] bytes = file.getBytes();
			String basePath=env.getProperty("UPLOADED_FOLDER");
			path = Paths.get("/MyImage/" + l + (++c) + "ranjeet.jpeg");
			path1 = Paths.get(basePath + path.toString());
			System.err.println("Base Path ============>>>>" + path1);
			Files.write(path1, bytes);
			 
			 
//			System.err.println("File Name=====>" + file.getOriginalFilename());
//			System.err.println("File Properties Address======>" + env.getProperty("UPLOADED_FOLDER"));
//			System.err.println("Complete File Path====>>"+path);
			 
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		Product addproduct = new Product();
		addproduct.setName(productname);
		addproduct.setQuantity(quantity);
		addproduct.setPrice(productprice);
		addproduct.setFilename(path.toString());//env.getProperty("UPLOADED_FOLDER")+file.getOriginalFilename());
		//addproduct.setFilename(file.getOriginalFilename());
		//addproduct.setFileaddress(env.getProperty("UPLOADED_FOLDER"));
		List<Product> productlist = iUserService.addProduct(addproduct);

		if (productlist != null) {
			Product viewproduct = new Product();
			allproduct = iUserService.getAllProduct(viewproduct);
			System.err.println(allproduct.isEmpty());
			attributes.addFlashAttribute("message", "Inserted Successfully");
			return new RedirectView("viewallProduct");
		} else {
			attributes.addFlashAttribute("message", "Not Inserted");
			return new RedirectView("viewallProduct");
		}

	}

	@RequestMapping(value = "/process-item", method = RequestMethod.POST)
	@ResponseBody // return data as json Formate
	public List<CartDomain> processItem(@RequestBody CartDTO cart) {
		CartDomain cartdomain = new CartDomain();
		System.err.println("Shopping cart data" + cart);
		cartdomain = DTODomainConverter.convertCartDTOToDomain(cart);
		iUserService.addCartData(cartdomain);
		List<CartDomain> cartdomain2 = iUserService.getAllCartData(cartdomain);
		System.err.println("this is the vlaue in Root Controller" + cartdomain2);
		return cartdomain2;
	}

	@RequestMapping(value = "/process", method = RequestMethod.GET)
	@ResponseBody // return data as json Formate
	public List<CartDomain> process(@RequestBody CartDTO cart) {
		CartDomain cartdomain = new CartDomain();
		System.err.println("Shopping cart data" + cart);
		cartdomain = DTODomainConverter.convertCartDTOToDomain(cart);
		iUserService.addCartData(cartdomain);
		List<CartDomain> cartdomain2 = iUserService.getAllCartData(cartdomain);
		System.err.println("this is the vlaue in Root Controller" + cartdomain2);
		return cartdomain2;
	}

	@RequestMapping(value = "/proces", method = RequestMethod.GET)
	public ModelAndView abc() {
		ModelAndView view = new ModelAndView();
		view.setViewName("view/viewallemployee1");
		return view;
	}

//	@RequestMapping(value = "/process-item", method = RequestMethod.GET)
//	public ModelAndView abc() {
//		ModelAndView view = new ModelAndView();
//		view.setViewName("view/viewallemployee1");
//		return view;
//	}

	@RequestMapping(value = "/process-item1", method = RequestMethod.POST)
	@ResponseBody // return data as json Formate
	public List<CartDomain> processItem1(@RequestBody CartDTO cart) {
		CartDomain cartdomain = new CartDomain();
		System.err.println("Shopping cart data" + cart);
		cartdomain = DTODomainConverter.convertCartDTOToDomain(cart);
		iUserService.removeCartData(cartdomain);
		List<CartDomain> cartdomain2 = iUserService.getAllCartData(cartdomain);

		System.err.println("this is the vlaue in Root Controller" + cartdomain2);
		return cartdomain2;
	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public ModelAndView resetPassword(@RequestParam("email") String maildto) {
		ModelAndView view = new ModelAndView();
		try {
			User user = new User();
			user.setEmail(maildto);
			iUserService.sendEmail(user);
			view.setViewName("view/index");
		} catch (Exception e) {

			e.printStackTrace();
		}
		return view;

	}
	// Image Call API
	@GetMapping("/MyImage/**")//Last FName in Database(MyImage\doc\filename.jpg)
	public void renderImage(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
			if (uploadDirectory != null) {
			String path = uploadDirectory;
			String servletPath=request.getServletPath();
			System.err.println(servletPath);
			String filename = URLDecoder.decode(servletPath.substring(1), "UTF-8");
			File file = new File(path, filename);
			response.setHeader("Content-Type", context.getMimeType(filename));
			response.setHeader("Content-Length", String.valueOf(file.length()));
			System.err.println("Length of file"+String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
			try {
				Files.copy(file.toPath(), response.getOutputStream());
			} catch (IOException e) {
			}
		}
	}
}
