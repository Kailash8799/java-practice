package repository;

import entities.Student;

public interface StudentRepository {
	Student get(Long id);

	void add(Student student);

	void update(Student student);

	void remove(Student student);
}

/*
 * As per Eric Evans' book Domain-Driven Design, the “repository is a mechanism
 * for encapsulating storage, retrieval, and search behavior, which emulates a
 * collection of objects.”
 * 
 *  a repository relies on DAOs for accessing data from various sources.
 * 
 */
