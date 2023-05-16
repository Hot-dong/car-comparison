package comunity.carcomunity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "car")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_idx")
    private Long carIdx;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "car_price")
    private String carPrice;

    @Column(name = "car_type")
    private String carType;
}
