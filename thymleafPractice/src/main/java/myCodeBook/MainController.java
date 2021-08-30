package myCodeBook;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myCodeBook.entities.LoginData;

@Controller
public class MainController {

//	@RequestMapping(value="/about",method = RequestMethod.GET)
//	public String about(Model md) {
//		md.addAttribute("name", "Prateek");
//		return "about";
//	}
//	
	@GetMapping("/about")
	public String about(Model md) {
		md.addAttribute("name", "Prateek");
		return "about";
	}
	
	
	
	@GetMapping("/iteration")
	public String iterate(Model model) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Tirchi");
		list.add("nazar k");
		list.add("m kurba");
		model.addAttribute("listName", list);
		return "iteration";
	}
	
	
	@GetMapping("/condition")
	public String conditionHandler(Model model) {
		model.addAttribute("isActive", true);
		model.addAttribute("gender", "M");
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(4);
		arrayList.add(5);
		model.addAttribute("myList", arrayList);
		return "condition";
	}
	
	
	@GetMapping("/service")
	public String service(Model model) {
		model.addAttribute("title", "I am title");
		model.addAttribute("subtitle", "sub title");
		return "service";
	}
	
	@GetMapping("/newAbout")
	public String newAbout() {
		return "newAbout";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	
	@GetMapping("/form")
	public String formValidation(Model model) {
		model.addAttribute("loginData", new LoginData());
		return "form";
	}
	
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData,  BindingResult bindingRes) {
		
		if(bindingRes.hasErrors()) {
			System.out.println("------------->>>"+bindingRes);
		  return "form";
		}
		System.out.println(loginData);
		return "success";
	}
	
}
