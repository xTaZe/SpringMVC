package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Employe;

/**
 * 
 * @author mboumallouga
 *
 */
public interface IEmployeService {

	void addEmploye(Employe employe);

	void updateEmploye(Employe employe);

	void deleteEmploye(Employe employe);

	Employe getEmployeById(int idEmploye);

	List<Employe> getAllEmployes();
}
