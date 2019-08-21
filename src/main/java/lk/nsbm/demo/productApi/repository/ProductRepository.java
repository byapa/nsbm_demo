package lk.nsbm.demo.productApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lk.nsbm.demo.productApi.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
