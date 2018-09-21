package com.yukoon.midautumnquiz.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class Favor {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;

	@Column(name = "ORDER_VALUE")
	private Integer order;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "OPTION_A")
	private String optionA;

	@Column(name = "OPTION_B")
	private String optionB;

	@Column(name = "OPTION_C")
	private String optionC;

	@Column(name = "OPTION_D")
	private String optionD;
}
