package com.boot.config.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.boot.config.resultmapper.CartMapper;
import com.boot.config.resultmapper.ProductMapper;
import com.boot.config.resultmapper.UserMapper;

import login.CartDomain;
import login.Product;
import login.User;

@Repository
//@Transactional(readOnly = true)
public class UserRepositoryImplementation implements IUserRepository {
	// static Integer count = 14;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public User validateUser(User user) {
		try {

			String sql = "select ed.id,ed.email,ed.password,ed.name,ed.gender,ed.dob,ed.roll_id,ed.status_id,ed.emp_id,ed.mobileno,ed.address,rm.roll_value from employee_details ed, roll_master rm where ed.roll_id = rm.roll_id and ed.email='"
					+ user.getEmail().trim() + "'and binary ed.password='" + user.getPassword().trim()
					+ "'and ed.status_id=1";
			System.err.println("Validate User SQL --  " + sql);

			user = jdbcTemplate.queryForObject(sql, new UserMapper());
			return user;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	@Override
	public List<User> addUserItem(User user) {
		try {
			// String sql="SELECT
			// pd.id,pd.product_name,pd.name,pd.price,pd.quantity,ed.email FROM
			// employee_details ed, product_details pd";

		} catch (Exception e) {

		}
		return null;
	}

	Integer itemcount;
	public Long registerUser(User user) {

		try {
			String coun = "select count(*) from employee_details";
			itemcount = jdbcTemplate.queryForObject(coun, Integer.class);
			System.err.println("Total count in database is=======>>>> " + itemcount);
			String insertsql = "INSERT INTO employee_details(email,name,password,mobileno,gender,dob,address,roll_id,status_id,emp_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
			KeyHolder holder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(insertsql, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, user.getEmail());
					ps.setString(2, user.getName());
					ps.setString(3, user.getPassword());
					ps.setString(4, user.getContact());
					ps.setString(5, user.getGender());
					ps.setString(6, user.getDob());
					ps.setString(7, user.getAddress());
					ps.setInt(8, user.getRoll_id());
					ps.setInt(9, user.getStatus_id());
					ps.setString(10, "emp0" + (++itemcount).toString());
					return ps;
				}
			}, holder);

			System.err.println("holder.getKey().longValue()   " + holder.getKey().longValue());
			return holder.getKey().longValue();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}

	@Override
	public int validateRegister(User user) {
		int emailcount = 0;
		try {

			String sql = "SELECT COUNT(email) FROM employee_details WHERE email='" + user.getEmail().trim() + "'";
			emailcount = jdbcTemplate.queryForObject(sql, Integer.class);

			// Integer emailcount1 = getJdbcTemplate().queryForObject(sql, new Object[] {
			// user.getEmail() }, Integer.class);
			// System.err.println("emailcount====" + emailcount);
			return emailcount;
		} catch (Exception e) {
			e.printStackTrace();

		}

		return emailcount;
	}

	@Override
	public int updateemployeeStatus(User user) {
		try {
			String sql = "update employee_details set status_id='" + user.getStatus_id() + "' where id='"
					+ user.getId() + "' ";
			return jdbcTemplate.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

//<===== Edit Employee Using Prepared Statement======>
	@Override
	public int editEmployee(User user) {
		try {
			String updatesql = "update employee_details set name= ?,email= ?,mobileno= ?,address= ?,roll_id= ? where id= ?";
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(updatesql);
					ps.setString(1, user.getName());
					ps.setString(2, user.getEmail());
					ps.setString(3, user.getContact());
					ps.setString(4, user.getAddress());
					ps.setInt(5, user.getRoll_id());
					ps.setInt(6, user.getId());
					return ps;
				}
			});

			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public int addEmployee(User user) {
		try {
			String insertsql = "INSERT INTO employee_details(emp_id,name,email,password,mobileno,gender,dob,address,roll_id,status_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(insertsql);
					ps.setString(1, user.getEmp_id());
					ps.setString(2, user.getName());
					ps.setString(3, user.getEmail());
					ps.setString(4, user.getPassword());
					ps.setString(5, user.getContact());
					ps.setString(6, user.getGender());
					ps.setString(7, user.getDob());
					ps.setString(8, user.getAddress());
					ps.setInt(9, user.getRoll_id());
					ps.setInt(10, user.getStatus_id());

					return ps;
				}
			});

			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;

		}

	}

	@Override

	public List<User> getAllEmployee(User user) {
		try {
			String sql = "select ed.id,ed.email,ed.password,ed.dob, ed.gender,ed.name,ed.roll_id,ed.status_id,ed.emp_id,ed.mobileno,ed.address,rm.roll_value from employee_details ed, roll_master rm"
					+ " where ed.roll_id = rm.roll_id ";
			if (user != null && user.getId() > 0) {
				System.err.println("-------User Id  Find " + user.getId());
				sql += " and ed.id = " + user.getId();
			}
			System.err.println("Fetching Query " + sql);

			List<User> employeeList = jdbcTemplate.query(sql, new UserMapper());
			return employeeList;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int addProduct(Product product) {
		try {
			System.err.println("NAME=======" + product.getName());
			String insertsql = "INSERT INTO product_details(product_name,price,quantity,file_name,file_address) VALUES(?,?,?,?,?)";
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(insertsql);
					ps.setString(1, product.getName());
					ps.setFloat(2, product.getPrice());
					ps.setInt(3, product.getQuantity());
					ps.setString(4, product.getFilename());
					ps.setString(5, product.getFileaddress());
//					ps.setBytes(4, product.getData());
					return ps;
				}
			});

			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public List<Product> getAllProduct(Product product) {
		try {
			String sql = "select id,product_name,price,quantity,file_name from product_details";
			System.err.println("Fetching Query " + sql);

			List<Product> productlist = jdbcTemplate.query(sql, new ProductMapper());
//			System.err.println("id from database in Repository" + product.getId());
			return productlist;

		} catch (DataAccessException e) {

			return null;
		}
	}

	@Override
	public int editProduct(Product user) {
		try {
			String updatesql = "update product_details set product_name= ?,price= ?,quantity= ? where id= ?";
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(updatesql);
					ps.setString(1, user.getName());
					ps.setFloat(2, user.getPrice());
					ps.setInt(3, user.getQuantity());
					ps.setInt(4, user.getId());
					return ps;
				}
			});

			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;

		}
	}

	@Override
	public void addItems(Product additem) {
		try {
			String sql = "update shoping_cart set item_id=?,user_email=?,price=?,item_quantity=?,total_price=? ";
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, additem.getItemid());
					ps.setString(2, additem.getEmail());
					ps.setInt(3, additem.getQuantity());
					ps.setFloat(4, additem.getPrice());
					ps.setFloat(5, additem.getTotalprice());
					return ps;
				}

			});

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addCardData(CartDomain cartdomain) {
		try {
			String insertsql = "INSERT INTO shopping_cart(user_id,item_id,item_price,item_quantity,item_name,total_price) VALUES(?,?,?,?,?,?)";
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(insertsql);
					ps.setInt(1, cartdomain.getUserid());
					ps.setInt(2, cartdomain.getItemid());
					ps.setFloat(3, cartdomain.getItemprice());
					ps.setInt(4, cartdomain.getItemquantity());
					ps.setString(5, cartdomain.getItemname());
					ps.setFloat(6, cartdomain.getItemprice() * cartdomain.getItemquantity());
					return ps;
				}
			});

			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<CartDomain> getAllCartData(CartDomain crd) {
		try {
			String sql = "select id,user_id,item_id,item_quantity,item_price,item_name,total_price from shopping_cart";
			List<CartDomain> cartDomain = jdbcTemplate.query(sql, new CartMapper());
			return cartDomain;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
//		return null;
	}

	@Override
	public int itemCount(CartDomain additem) {
		int itemcount = 0;
		try {
			String sql = "SELECT item_quantity FROM shopping_cart WHERE user_id='" + additem.getUserid()
					+ "' AND item_id='" + additem.getItemid() + "'";
			itemcount = jdbcTemplate.queryForObject(sql, Integer.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemcount;
	}

	@Override
	public void updateCartItem(CartDomain cartdomain) {
		try {
			String sqlid = "SELECT id FROM shopping_cart WHERE user_id='" + cartdomain.getUserid() + "' AND item_id='"
					+ cartdomain.getItemid() + "'";
			int id = jdbcTemplate.queryForObject(sqlid, Integer.class);
			System.err.println("id in update cartitem" + id);
			String sql = "UPDATE shopping_cart SET item_quantity=?,total_price=? WHERE item_id='"
					+ cartdomain.getItemid() + "' AND id='" + id + "'";
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, cartdomain.getItemquantity());
					ps.setFloat(2, cartdomain.getTotalprice());
					return ps;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int removeCardData(CartDomain cartdomain) {
		try {
			String sqlid = "SELECT id FROM shopping_cart WHERE user_id='" + cartdomain.getUserid() + "' AND item_id='"
					+ cartdomain.getItemid() + "'";
			int id = jdbcTemplate.queryForObject(sqlid, Integer.class);
			System.err.println("id in update cartitem in deletion======>" + id);
			String insertsql = "delete from shopping_cart where id= ? and user_id=? and item_id=?";
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(insertsql);
					ps.setInt(1, id);
					ps.setInt(2, cartdomain.getUserid());
					ps.setFloat(3, cartdomain.getItemid());
					return ps;
				}
			});

			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public User sendEmail(User user) {
		User user1 = new User();
		try {
			String emailQuery = "select ed.id,ed.email,ed.password,ed.dob, ed.gender,ed.name,ed.roll_id,ed.status_id,ed.emp_id,ed.mobileno,ed.address,rm.roll_value from employee_details ed, roll_master rm"
					+ " where ed.roll_id=rm.roll_id and ed.email='" + user.getEmail() + "' ";
			System.err.println(emailQuery);
			System.err.println("Repository Class Email  (Get Email)" + user.getEmail());
			user1 = jdbcTemplate.queryForObject(emailQuery, new UserMapper());
			System.err.println(user1);
			System.err.println(emailQuery);
			return user1;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}


	@Override
	public int validateEmployee(User addemp) {
		int totalcount = 0;
		try {
			String fetch = "select count(*) from employee_details where email='" + addemp.getEmail() + "'";
			totalcount = jdbcTemplate.queryForObject(fetch, Integer.class);
			return totalcount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.err.println("count value in repository ====>" + totalcount);
		return totalcount;
	}

}
