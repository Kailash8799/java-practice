package dao;

import entities.Student;

public interface StudentDAO {
	Student get(long id);

	void add(Student student);

	void update(Student student);

	void remove(Student student);
}

/*
 * DAO seems a perfect candidate to access the data, and a repository is an
 * ideal way to implement a business use-case.
 */
