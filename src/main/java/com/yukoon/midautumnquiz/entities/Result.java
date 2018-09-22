package com.yukoon.midautumnquiz.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Result {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(name = "DYNASTY")
    private String dynasty;

    @Column(name = "POET")
    private String poet;

    @Column(name = "BELONG_TO")
    private Integer belongTo;

}
