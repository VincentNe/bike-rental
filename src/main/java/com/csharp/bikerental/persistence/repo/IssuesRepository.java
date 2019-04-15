package com.csharp.bikerental.persistence.repo;

import com.csharp.bikerental.persistence.model.Issues;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuesRepository extends CrudRepository<Issues,Long> {

}
