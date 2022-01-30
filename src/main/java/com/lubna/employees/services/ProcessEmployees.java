package com.lubna.employees.services;

import com.lubna.employees.model.Employee;
import com.lubna.employees.model.EmployeeWorkTogether;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class ProcessEmployees {

	public List<EmployeeWorkTogether> processEmployees(List<Employee> employeeList) {
		List<EmployeeWorkTogether> employeeWorkTogethers = new ArrayList<>();

		// Group Employee by Project ID
		Map<String, List<Employee>> projectMap = new HashMap<>();
		for (Employee e : employeeList) {
			List<Employee> employeeForProject = projectMap.get(e.getProjectID());
			if (employeeForProject == null) {
				employeeForProject = new ArrayList<Employee>() {
					{
						add(e);
					}
				};
				projectMap.put(e.getProjectID(), employeeForProject);
			} else {
				employeeForProject.add(e);
			}
		}


		for (String projectId : projectMap.keySet()) {
			List<Employee> employeeForProject = projectMap.get(projectId);

			for (int i = 0; i < employeeForProject.size() - 1; i++) {
				for (int j = 1; j < employeeForProject.size(); j++) {
					Employee em1 = employeeForProject.get(i);
					em1 = convertDate(em1);
					Employee em2 = employeeForProject.get(j);
					em2 = convertDate(em2);

					if ((em1.getDateToD().compareTo(em2.getDateToD()) <= 0
							&& em1.getDateToD().compareTo(em2.getDateFromD()) > 0)
							|| (em2.getDateToD().compareTo(em1.getDateToD()) <= 0
									&& em2.getDateToD().compareTo(em1.getDateFromD()) > 0)) {

						Date dateFirst, dateSecond;

						if (em1.getDateFromD().compareTo(em2.getDateFromD()) > 0) {
							dateFirst = em1.getDateFromD();
						} else
							dateFirst = em2.getDateFromD();

						if (em1.getDateToD().compareTo(em2.getDateToD()) < 0) {
							dateSecond = em1.getDateToD();
						} else
							dateSecond = em2.getDateToD();

						long diffInMillies = Math.abs(dateSecond.getTime() - dateFirst.getTime());
						Long daysWorked = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

						EmployeeWorkTogether emWork = new EmployeeWorkTogether();
						emWork.setDaysWorked(daysWorked.intValue());
						emWork.setEmployeeId1(em1.getEmployeeID());
						emWork.setEmployeeId2(em2.getEmployeeID());
						emWork.setProjectId(projectId);
						employeeWorkTogethers.add(emWork);

					}

				}
			}
		}

		return employeeWorkTogethers;
	}

	private Employee convertDate(Employee em) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dateFrom, dateTo;
			if (em.getDateFrom().equals("NULL")) {
				dateFrom = new Date();
			} else
				dateFrom = formatter.parse(em.getDateFrom());

			if (em.getDateTo().equals("NULL")) {
				dateTo = new Date();
			} else
				dateTo = formatter.parse(em.getDateTo());

			em.setDateFromD(dateFrom);
			em.setDateToD(dateTo);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return em;
	}

}
