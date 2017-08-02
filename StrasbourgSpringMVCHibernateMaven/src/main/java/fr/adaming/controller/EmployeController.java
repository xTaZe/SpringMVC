package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Employe;
import fr.adaming.service.IEmployeService;

/**
 * 
 * @author mboumallouga
 *
 */
@Controller
@RequestMapping(value = "/employe")
public class EmployeController {

	@Autowired
	private IEmployeService employeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomeEmploye(ModelMap model) {

		model.addAttribute("name", "APPLICATION DE GESTION DES EMPLOYES");
		model.addAttribute("salutation", "Avec Spring MVC @Author BOUMALLOUGA Mohamed");

		return "home";
	}

	@RequestMapping(value = "/listemployes", method = RequestMethod.GET)
	public String listEmployes(ModelMap model) {
		List<Employe> liste = employeService.getAllEmployes();
		model.addAttribute("employeeList", liste);
		return "employes";
	}

	@RequestMapping(value = "/addEmploye", method = RequestMethod.GET)
	public ModelAndView addEmploye() {
		String viewName = "addEmploye";
		return new ModelAndView(viewName, "employe", new Employe());
	}

	@RequestMapping(value = "/insererEmploye", method = RequestMethod.POST)
	public String insererEmploye(@ModelAttribute("employe") Employe pEmploye, ModelMap model) {

		if (pEmploye.getId() == 0) {
			employeService.addEmploye(pEmploye);
		} else {
			employeService.updateEmploye(pEmploye);
		}

		model.addAttribute("employeeList", employeService.getAllEmployes());
		return "employes";
	}

	@RequestMapping(value = "/deleteEmploye/{employeID}", method = RequestMethod.GET)
	public String supprimerEmploye(@PathVariable("employeID") int IdEmploye, ModelMap model) {
		Employe empl = employeService.getEmployeById(IdEmploye);
		employeService.deleteEmploye(empl);
		model.addAttribute("employeeList", employeService.getAllEmployes());

		return "employes";
	}

	@RequestMapping(value = "/editEmploye", method = RequestMethod.GET)
	public ModelAndView editerEmploye(int idEmploye) {
		Employe empl = employeService.getEmployeById(idEmploye);
		String viewName = "addEmploye";
		return new ModelAndView(viewName, "employe", empl);
	}

}
