package com.xy.pi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "points_of_interest")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PointsOfInterest {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int xCoordinate;
    private int yCoordinate;
    private LocalDateTime createdAt;
    private boolean active;
}
