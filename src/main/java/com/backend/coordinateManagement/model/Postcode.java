package com.backend.coordinateManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "postcode")
@AllArgsConstructor
@NoArgsConstructor
public class Postcode {
  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "postcode")
  private String postcode;

  @Column(name = "latitude")
  private String latitude;

  @Column(name = "longtitude")
  private String longitude;
}