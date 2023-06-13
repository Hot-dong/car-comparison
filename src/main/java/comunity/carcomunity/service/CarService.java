package comunity.carcomunity.service;

import comunity.carcomunity.entity.Car;
import comunity.carcomunity.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public Car getCarList(String name) {
        return carRepository.findByCarName(name);
    }

    public Page<Car> getSearchList(String search, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by(Sort.Direction.ASC, "carName"));
        return carRepository.findByCarNameLike("%" + search + "%", pageable);
    }

}