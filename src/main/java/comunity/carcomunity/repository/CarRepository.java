package comunity.carcomunity.repository;

import comunity.carcomunity.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    public Page<Car> findByCar_nameLike(String name, Pageable pageable);
}
