package com.spring.Springdevelopment.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

//@Data Lombok reference → Getter, Setter, Required Args Constructor, ToString and EqualsAndHashCode
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long departmentId;
    @NotBlank(message = "Please add Department Name")
/* @Length(max = 20, min = 1)
    @Size(max = 20, min = 0)
    @Positive
    @Negative
    @PositiveOrZero
    @NegativeOrZero
    @Future
    @Past
    @PastOrPresent*/
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
