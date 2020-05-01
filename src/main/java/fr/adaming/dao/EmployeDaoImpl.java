package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Employe;

/**
 * 
 * @author mboumallouga
 *
 */
@Repository
public class EmployeDaoImpl implements IEmployeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addEmploye(Employe employe) {
		Session session = sessionFactory.openSession();
		session.save(employe);
	}

	@Override
	public void updateEmploye(Employe employe) {

		Session session = sessionFactory.openSession();
		session.merge(employe);
		session.flush();

	}

	@Override
	public void deleteEmploye(Employe employe) {
		Session session = sessionFactory.openSession();
		session.delete(employe);
		session.flush();
	}

	@Override
	public Employe getEmployeById(int idEmploye) {
		Session session = sessionFactory.openSession();
		return (Employe) session.get(Employe.class, idEmploye);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employe> getAllEmployes() {
		Session session = sessionFactory.openSession();
		return session.createCriteria(Employe.class).list();
	}

}
