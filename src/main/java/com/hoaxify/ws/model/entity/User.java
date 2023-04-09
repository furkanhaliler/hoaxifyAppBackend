package com.hoaxify.ws.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Entity
@Getter
@Table(name = "USERS")
@Accessors(chain = true, fluent = true)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Setter
  private String userName;

  @Setter
  private String displayName;

  @Setter
  private String password;
}
