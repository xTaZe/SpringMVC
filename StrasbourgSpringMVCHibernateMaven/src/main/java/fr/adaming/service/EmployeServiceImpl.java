package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IEmployeDao;
import fr.adaming.model.Employe;

/**
 * 
 * @author mboumallouga
 *
 */
@Service("employeServiceBean")
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	private IEmployeDao employeDAO;

	public void setEmployeDAO(IEmployeDao employeDAO) {
		this.employeDAO = employeDAO;
	}

	@Override
	public void addEmploye(Employe employe) {
		employeDAO.addEmploye(employe);
	}

	@Override
	public void updateEmploye(Employe employe) {
		employeDAO.updateEmploye(employe);
	}

	@Override
	public void deleteEmploye(Employe employe) {
		employeDAO.deleteEmploye(employe);
	}

	@Override
	public Employe getEmployeById(int idEmploye) {

		return employeDAO.getEmployeById(idEmploye);
	}

	@Override
	public List<Employe> getAllEmployes() {
		return employeDAO.getAllEmployes();
	}

}
