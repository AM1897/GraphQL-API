package se.dsve.graphqlapi.repository;

import se.dsve.graphqlapi.model.DepartmentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentUserRepository extends JpaRepository<DepartmentUser, Long> {
}