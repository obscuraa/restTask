package com.group.restTask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.group.restTask.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select sum(u.numOfVisits) from User u where u.dayOfVisit = :dayOfVisit")
    long findVisitsByDay(@Param("dayOfVisit") long dayOfVisit);

    @Query("select count(distinct u) from User u where u.dayOfVisit = :dayOfVisit")
    long findUniqueUsersByDay(@Param("dayOfVisit") long dayOfVisit);

    @Query("select count(u) from User u where u.dayOfVisit = :dayOfVisit and u.numOfVisits > 9")
    long findUniqueAndLoyalUsersByDay(@Param("dayOfVisit") long dayOfVisit);

    @Query("select sum(u.numOfVisits) from User u where u.dayOfVisit = 1")
    long findCurrentDayVisits();

    @Query("select count(distinct u) from User u where u.dayOfVisit = 1")
    long findCurrentDayUniqueUsers();
}
