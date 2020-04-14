package com.springboot.mysql.cascade;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer msgId;
  @Column(nullable = false)
  private String msgText;
  @Column(nullable = true, length = 32)
  private String msgSummary;
}