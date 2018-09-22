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
public class Record {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;

	@JoinColumn(name = "RESULT_ID")
	@ManyToOne
	private Result result;
}
