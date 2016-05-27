package com.ffiaux;

import com.ffiaux.db.DepartmentRepository;
import com.ffiaux.db.EmployeeRepository;
import com.ffiaux.model.Department;
import com.ffiaux.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MongoTestApplication implements CommandLineRunner {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongoTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeRepository.deleteAll();

		// save a couple of employers
		employeeRepository.save(new Employee("Honey", "Edwards", 40, "h.edwards@randatmail.com", "9011-2075", 3756.42));
		employeeRepository.save(new Employee("Sydney", "Turner", 28, "s.turner@randatmail.com", "6652-5891", 5065.51));
		employeeRepository.save(new Employee("Harold", "Stewart", 55, "h.stewart@randatmail.com", "9123-4592", 1198.44));
		employeeRepository.save(new Employee("Eleanor", "Wright", 30, "e.wright@randatmail.com", "3864-2583", 7021.82));
		employeeRepository.save(new Employee("Julian", "Harper", 39, "j.harper@randatmail.com", "5020-2888", 6202.91));
		employeeRepository.save(new Employee("Clark", "Stewart", 35, "c.stewart@randatmail.com", "7796-0845", 3164.29));
		employeeRepository.save(new Employee("Connie", "Holmes", 19, "c.holmes@randatmail.com", "9926-1815", 7271.03));
		employeeRepository.save(new Employee("Maximilian", "Cooper", 31, "m.cooper@randatmail.com", "5992-3780", 6707.04));
		employeeRepository.save(new Employee("Garry", "Morris", 39, "g.morris@randatmail.com", "6078-5660", 9520.40));
		employeeRepository.save(new Employee("Aston", "Harrison", 27, "a.harrison@randatmail.com", "3177-3362", 9463.23));
		employeeRepository.save(new Employee("Jessica", "Elliott", 30, "j.elliott@randatmail.com", "7774-9635", 1197.09));
		employeeRepository.save(new Employee("Jasmine", "Holmes", 56, "j.holmes@randatmail.com", "7678-8530", 8015.84));
		employeeRepository.save(new Employee("Alan", "Evans", 31, "a.evans@randatmail.com", "6562-7831", 8780.72));
		employeeRepository.save(new Employee("Maria", "Brooks", 35, "m.brooks@randatmail.com", "8239-8642", 9552.25));
		employeeRepository.save(new Employee("Carina", "Turner", 39, "c.turner@randatmail.com", "7232-5610", 979.22));
		employeeRepository.save(new Employee("Amber", "Harrison", 45, "a.harrison@randatmail.com", "7223-3684", 6401.23));
		employeeRepository.save(new Employee("Anna", "Kelly", 33, "a.kelly@randatmail.com", "8659-3960", 2219.61));
		employeeRepository.save(new Employee("Audrey", "Gray", 27, "a.gray@randatmail.com", "8369-9491", 5133.79));
		employeeRepository.save(new Employee("Daryl", "Harrison", 38, "d.harrison@randatmail.com", "4156-1438", 7827.63));
		employeeRepository.save(new Employee("Fenton", "Henderson", 30, "f.henderson@randatmail.com", "2019-6106", 8984.11));

		departmentRepository.deleteAll();

		Department d = new Department("R&D", employeeRepository.findByFirstName("Jasmine"));
		departmentRepository.save(d);

		List<Employee> es = employeeRepository.findAll();
		for(Employee e : es)
		{
			e.setDepartment(d);
			employeeRepository.save(e);
		}
	}
}