package com.spring.example.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SampleDTOList {
	private List<SampleDTO> list; // ArrayList<SampleDTO>의 주소값
	
	public SampleDTOList() {
		list = new ArrayList<SampleDTO>();
	}
}
