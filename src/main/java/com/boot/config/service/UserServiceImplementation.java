package com.boot.config.service;

import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.boot.config.repository.IUserRepository;

import login.CartDomain;
import login.MailSender;
import login.Product;
import login.User;

@Service
public class UserServiceImplementation implements IUserService {

	@Autowired
	IUserRepository iUserRepository;
	@Autowired
	JavaMailSender javaMailSender;
	@Autowired
	private Environment env;

	@Override
	public User validateUser(User user) {
		try {
			if (user != null && user.getEmail() != null && user.getEmail().trim() != null && user.getPassword() != null
					&& user.getPassword().trim() != null) {
				User useradmin = iUserRepository.validateUser(user);
				return useradmin;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<User> getAllEmployee(User user) {
		List<User> allemployee = iUserRepository.getAllEmployee(user);
		return allemployee;
	}

	@Override
	public User addUser(User user) {
		try {
			if (user != null && user.getEmail() != null && user.getEmail().trim() != null) {

				int emailcount = iUserRepository.validateRegister(user);
				System.err.println("emailcount checking========" + emailcount);
				if (emailcount == 0) {
					user.setStatus_id(1);
					// if (user.getRoll_id() == 0) {
						user.setRoll_id(3);
					// }
					int register = iUserRepository.registerUser(user).intValue();
					System.err.println("LAST ID===" + register);
					user.setId(register);
					List<User> userList = iUserRepository.getAllEmployee(user);

					if (userList != null) {

						User dbuser = userList.get(0);
						System.err.println("value============================" + dbuser.getId());
						return dbuser;
					}
				} else
					return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int validateRegister(User user) {
		int emailcount = 0;
		try {
			emailcount = iUserRepository.validateRegister(user);
			System.err.println("====count========" + emailcount);

			// int register = iUserRepository.registerUser(user).intValue();
			// user.setId(register);
			List<User> userList = iUserRepository.getAllEmployee(user);
			System.err.println("After DB ISERT " + userList.isEmpty());
			if (userList != null) {

//				User dbuser = userList.get(0);
				return emailcount;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return emailcount;

	}

//////////////------------For change Status.--------------/////

	@Override
	public List<User> updateemployeeStatus(User user) {

		try {
			
			iUserRepository.updateemployeeStatus(user);
			user=new User();
			List<User> alluser = iUserRepository.getAllEmployee(user);
			return alluser;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public List<User> editEmployee(User user) {

		try {
			if (user != null && user.getEmail() != null && user.getEmail().trim() != null && user.getName() != null
					&& user.getAddress() != null && user.getContact() != null && user.getRoll_id() != 0
					&& user.getId() != 0) {
				iUserRepository.editEmployee(user);
			} else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		try {
			List<User> user2 = iUserRepository.getAllEmployee(user);
			return user2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User> addEmployee(User user) {

		try {
			if (user != null && user.getEmail() != null && user.getEmail().trim() != null) {
				iUserRepository.addEmployee(user);
			} else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		try {
			List<User> user2 = iUserRepository.getAllEmployee(user);
			return user2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Product> addProduct(Product product) {
		try {
			if (product != null && product.getName() != null && product.getName().trim() != null
					&& product.getPrice() != null) {
				iUserRepository.addProduct(product);
			} else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		try {
			List<Product> product1 = iUserRepository.getAllProduct(product);
			return product1;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> getAllProduct(Product product) {
		List<Product> allproduct = iUserRepository.getAllProduct(product);
		return allproduct;
	}

	@Override
	public List<Product> editProduct(Product product) {
		try {
			if (product != null && product.getName() != null && product.getName().trim() != null
					&& product.getPrice() != null) {
				iUserRepository.editProduct(product);
			} else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		try {
			List<Product> product2 = iUserRepository.getAllProduct(product);
			return product2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Product> addItems(Product additem) {
		try {
			if (additem != null) {
				iUserRepository.addItems(additem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CartDomain> getAllCartData(CartDomain cartdom) {
		List<CartDomain> allCartdata = iUserRepository.getAllCartData(cartdom);
		return allCartdata;
	}

	@Override
	public List<CartDomain> addCartData(CartDomain cartdomain) {
		try {
			if (cartdomain != null) {
				int itemcount = iUserRepository.itemCount(cartdomain);
				System.err.println("item count data------->" + itemcount);
				if (itemcount > 0) {
					cartdomain.setItemquantity(++itemcount);
					Float totalprice = itemcount * (cartdomain.getItemprice());
					cartdomain.setTotalprice(totalprice);
					iUserRepository.updateCartItem(cartdomain);
				} else {
					// cartdomain.setTotalprice(cartdomain.getItemprice());
					iUserRepository.addCardData(cartdomain);
				}

			}
			List<CartDomain> addCartdata = iUserRepository.getAllCartData(cartdomain);
			return addCartdata;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CartDomain> removeCartData(CartDomain cartdomain) {
		try {
			if (cartdomain != null) {
				int itemcount = iUserRepository.itemCount(cartdomain);
				System.err.println("item count data------->" + itemcount);
				if (itemcount > 1) {
					cartdomain.setItemquantity(--itemcount);
					Float totalprice = itemcount * (cartdomain.getItemprice());
					cartdomain.setTotalprice(totalprice);
					iUserRepository.updateCartItem(cartdomain);
				} else {
					cartdomain.setTotalprice(cartdomain.getItemprice());
					iUserRepository.removeCardData(cartdomain);
				}

			}
			List<CartDomain> addCartdata = iUserRepository.getAllCartData(cartdomain);
			return addCartdata;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void sendEmail(User user) {
		try {
			if (user != null && user.getEmail() != null && user.getEmail().trim() != null) {

				User user1 = iUserRepository.sendEmail(user);
				MailSender mailSender = new MailSender();
				MimeMessage mimeMessage = javaMailSender.createMimeMessage();
				try {
					// Properties env = new Properties();
					MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,
							MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
					
					System.err.println("from Properties file==="+env.getProperty("spring.mail.username"));
					messageHelper.setFrom(env.getProperty("spring.mail.username"));
					messageHelper.setTo(user1.getEmail());
					messageHelper.setSubject("Hii This is Test Email");
					messageHelper.setText(
							"Hi, " + "<br><br> " + user1.getName() + " Your Password is '"
									+ user1.getPassword().trim() + "'  you can login now.  "
									+ " <br><br>Thanks & Regards<br>RN",
							true);
					javaMailSender.send(mimeMessage);
					System.err.println("Mail send Succussfully!!!!");
//					mailSender.sendMail(javaMailSender, mimeMessage);
				} catch (Exception e) {
					e.printStackTrace();
				}

//				ms.sendMail(javaMailSender, "yk635541@gmail.com", user1.getEmail(), "Testing", "hiii");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boot.config.service.IUserService#validateEmployee(login.User)
	 */
	@Override
	public int validateEmployee(User addemp) {
		// TODO Auto-generated method stub
		int count = 0;
		if (addemp.getEmail() != null) {
		try {
				count = iUserRepository.validateEmployee(addemp);
				// return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
		System.err.println("Count value in Service======>" + count);

		return count;

	}
}