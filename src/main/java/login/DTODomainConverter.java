package login;

import com.boot.config.dto.AddEmployeeDTO;
import com.boot.config.dto.ProductDTO;

public class DTODomainConverter {

	public static Product convertProductDTOToDomain(ProductDTO prd) {
		Product product = new Product();
		product.setName(prd.getName());
		product.setPrice(prd.getPrice());
		product.setQuantity(prd.getQuantity());
		product.setId(prd.getId());
		return product;
	}

	public static ProductDTO convertProductDomainToDTO(Product product) {
		ProductDTO prdo = new ProductDTO();
		prdo.setName(product.getName());
		prdo.setPrice(product.getPrice());
		prdo.setQuantity(product.getQuantity());
		prdo.setId(product.getId());
		return prdo;
	}

	public static User convertAddEmployeeDTOToDomain(AddEmployeeDTO addempdto) {
		User user = new User();
		user.setEmp_id(addempdto.getId());
		user.setAddress(addempdto.getAddress());
		user.setContact(addempdto.getContact());
		user.setDob(addempdto.getDob());
		user.setEmail(addempdto.getEmail());
		user.setGender(addempdto.getGender());
		user.setStatus_id(addempdto.getStatus());
		user.setName(addempdto.getName());
		user.setPassword(addempdto.getPassword());
		user.setRoll_id(addempdto.getRole());

		return user;
	}

}
