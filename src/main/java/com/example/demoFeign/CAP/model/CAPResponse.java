package com.example.demoFeign.CAP.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class CAPResponse {
	@JsonProperty("Siret")
	private List<SiretObj> siret = new ArrayList<>();

	public CAPResponse(){

	}

	public CAPResponse(List<SiretObj> siret){
		this.siret = siret;
	}

	public List<SiretObj> getSiret() {
		return siret;
	}

	public void setSiret(List<SiretObj> siret) {
		this.siret = siret;
	}
}
