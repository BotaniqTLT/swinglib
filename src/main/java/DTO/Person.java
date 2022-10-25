package DTO;

import lombok.Getter;
import lombok.Setter;
import ru.botaniqtlt.libs.DAO.DaoEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name="person")
public class Person implements DaoEntity{

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private Integer age;

}
