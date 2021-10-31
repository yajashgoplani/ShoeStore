package com.controller;


import java.sql.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.model.Purchase;
import com.model.Shoe;
import com.model.User;
import com.service.PurchaseService;
import com.service.ShoesService;
import com.service.UsersService;


@RestController
@RequestMapping("/shoe")
public class ActionsController {

	// Category:1 for men , 2 for women, 3 for boy and 4 for girl
	@Autowired
	private ShoesService shoeservice;
	@Autowired
	private PurchaseService orderservice;
	@Autowired
	private UsersService userservice;


	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userservice.getUsers();
	}
	
	
	@GetMapping(value = "/men")
	public List<Shoe> menShoesForm() {
		return shoeservice.getMensShoeData();
	}

	@GetMapping(value = "/women")
	public List<Shoe> womenMethod() {
		return shoeservice.getWomensShoeData();	
		
	}

	@GetMapping("/boy")
	public List<Shoe> boyMethod() {
		return shoeservice.getBoysShoeData();
	}
	
	@GetMapping("/girl")
	public List<Shoe> girlMethod() {
		return shoeservice.getGirlsShoeData();
	}

	@GetMapping("/shoes/{id}/SelectedShoe")
	public Shoe selectedShoeInfoMethod(@PathVariable int id) {

		try {
				return shoeservice.getshoesDataByIdService(id);
		} catch (Exception e) {
			System.out.println(" [ACTIONS CONTROLLER] WARNING: METHOD ERROR OCCURED ----------"+ e.getMessage());
			return new Shoe();
		}

	}

	@PostMapping(value = "/orderinfo", consumes = "Application/JSON")
	public String orderInforMethod(@RequestBody Purchase p) {
			System.out.println(p);
			p.setTotalprice(p.getPrice() * (double)p.getQuantity());
			System.out.println(p.getTotalprice());
			try {
				long millis = System.currentTimeMillis();
				Date date = new java.sql.Date(millis);
				p.setDate(date);
				orderservice.insertBookingInfoService(p);
			} catch (Exception e) {
					return "[ACTIONS CONTROLLER] WARNING: METHOD ERROR OCCURED ----------"+ e.getMessage();
			}
			return "Successful addition of record";

	}
	
	@GetMapping("/recordPayment/{id}/{date}")
	public List<Purchase> recordPaymentMethod(@PathVariable int id,@PathVariable Date date) {

		try {
				return orderservice.getRequiredCompleteTransactionsDataService(id,date);
		} catch (Exception e) {
			System.out.println(" [ACTIONS CONTROLLER] WARNING: METHOD ERROR OCCURED ----------"+ e.getMessage());
		}
		return List.of(new Purchase());
	}
	
	
	@GetMapping("/getcompletemenshoesforAdmin")
	public List<Shoe> getcompletemenshoesforAdmin() {

		try {
			return shoeservice.getMensShoeData();
		} catch (Exception e) {
			System.out.println(" [ACTIONS CONTROLLER] WARNING: METHOD ERROR OCCURED ----------"+ e.getMessage());
		}
		return List.of(new Shoe());
	}
 
	@GetMapping("/womenshoe")
	public List<Shoe> getcompletewomenshoesforAdmin() {

		try {
			return shoeservice.getWomensShoeData();
		} catch (Exception e) {
			System.out.println(" [ACTIONS CONTROLLER] WARNING: METHOD ERROR OCCURED ----------"+ e.getMessage());
		}
		return List.of(new Shoe());
	}
	
	@GetMapping("/boyshoe")
	public List<Shoe> getcompleteboyshoesforAdmin() {

		try {
			return shoeservice.getBoysShoeData();
		} catch (Exception e) {
			System.out.println(" [ACTIONS CONTROLLER] WARNING: METHOD ERROR OCCURED ----------"+ e.getMessage());
		}
		return List.of(new Shoe());
	}
		
	@GetMapping("/girlshoe")
	public List<Shoe> getcompletegirlshoesforAdmin() {

		try {
			return shoeservice.getGirlsShoeData();
		} catch (Exception e) {
			System.out.println(" [ACTIONS CONTROLLER] WARNING: METHOD ERROR OCCURED ----------"+ e.getMessage());
		}
		return List.of(new Shoe());
	}
		
	@PostMapping(value = "/addShoesForm")
	public boolean addShoesForm(@RequestBody Shoe s) {
		return shoeservice.insertNewProductService(s);
	}

	@GetMapping("/usersList/{id}")
	public List<User> usersListMethod(@PathVariable int id) {
		List<User> usersList = null;

		try {

			usersList = userservice.getUserDataService(id);

			if (!usersList.isEmpty()) {

				return usersList;
			} else {
				return List.of(new User());
			}

		} catch (Exception e) {
			System.out.println(" [ACTIONS CONTROLLER] WARNING: METHOD ERROR OCCURED ----------"+ e.getMessage());
		}
		return List.of(new User());

	}
	

	@GetMapping("/reports")
	public double reportsMethod() {

		double totalSales = 0;
		List<Purchase> orderedShoeList = null;
		try {
			orderedShoeList = orderservice.getCompleteTransactionsDataService();
			if (orderedShoeList != null) {
				for (Purchase osl : orderedShoeList) {
					totalSales = totalSales + osl.getTotalprice();
				}
			}
			return totalSales;
		} catch (Exception e) {
			System.out.println(" [ACTIONS CONTROLLER] WARNING: METHOD ERROR OCCURED ----------"+ e.getMessage());
		}
		return 0;
	}
	

	@PostMapping("/requiredmembers")
	public String requiredMembersMethod(@RequestBody User u) {
		userservice.insertUserDataService(u);
		return "SuccessFull";
	}
	
}
