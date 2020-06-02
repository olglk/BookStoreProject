package com.example.demo.repository.TablePerClass;

import com.example.demo.model.TablePerClass.Mersedes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface MersedesRepository extends JpaRepository<Mersedes, Integer> {
}
