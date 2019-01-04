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

import com.boot.config.resultmapper.ProductMapper;
import com.boot.config.resultmapper.UserMapper;

import login.Product;
import login.User;

@Repository
public class UserRepositoryImplementation implements IUserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public User validateUser(User user) {
		try {

			String sql = "select ed.id,ed.email,ed.password,ed.name,ed.roll_id,ed.status_id,ed.emp_id,ed.mobileno,ed.address,rm.roll_value from employee_details ed, roll_master rm where ed.roll_id = rm.roll_id and ed.email='"
					+ user.getEmail().trim() + "'and binary ed.password='" + user.getPassword().trim()
					+ "'and ed.status_id=1";
			System.err.println("Validate User SQL --  " + sql);
			// System.err.println("Validate User SQL -- " + sql);

			user = jdbcTemplate.queryForObject(sql, new UserMapper());
			return user;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	@Override
	public List<User>  addUserItem(User user)
	{
		try
		{
			//String sql="SELECT pd.id,pd.product_name,pd.name,pd.price,pd.quantity,ed.email FROM employee_details ed, product_details pd";

		}
		catch (Exception e) {
			
		}
		return null;
	}
	public Long registerUser(User user)
	{
		try {
			// System.err.println("NAME=======" + user.getName());
			String insertsql = "INSERT INTO employee_details(email,name,password,mobileno,gender,dob,address,roll_id,status_id) VALUES(?,?,?,?,?,?,?,?,?)";
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
		int emailcount=0;
		try {
			
			System.err.println("email=====/////" + user.getEmail());
			String sql = "SELECT COUNT(email) FROM employee_details WHERE email='" + user.getEmail().trim() + "'";
			 emailcount=jdbcTemplate.queryForObject(sql, Integer.class);
			
			//Integer emailcount1 = getJdbcTemplate().queryForObject(sql, new Object[] { user.getEmail() }, Integer.class);
			System.err.println("emailcount====" + emailcount);


		} catch (Exception e) {
			e.printStackTrace();
			
		
		}
		
		return emailcount;
		
	

	}

	public JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return null;
	}


	

	@Override
	public int updateemployeeStatus(User user) {
		try {
			String sql = "update employee_details set status_id='" + user.getStatus_id() + "' where email='"
					+ user.getEmail() + "' ";
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
			System.err.println("NAME=======" + user.getName());
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
			String insertsql = "INSERT INTO product_details(product_name,price,quantity) VALUES(?,?,?)";
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(insertsql);
					ps.setString(1, product.getName());
					ps.setFloat(2, product.getPrice());
					ps.setInt(3, product.getQuantity());
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
			String sql = "select id,product_name,price,quantity from product_details";
			System.err.println("Fetching Query " + sql);

			List<Product> productlist = jdbcTemplate.query(sql, new ProductMapper());
//			System.err.println("id from database in Repository" + product.getId());
			return productlist;

		} catch (DataAccessException e) {

			return null;
		}
	}
	
	
	
	
		
	

	@Override
	public int editProduct(Product user)
	{
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
		try
		{
			String sql="update shoping_cart set item_id=?,user_email=?,price=?,item_quantity=?,total_price=? ";
			jdbcTemplate.update(new PreparedStatementCreator(){

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps=con.prepareStatement(sql);
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

	
	}

