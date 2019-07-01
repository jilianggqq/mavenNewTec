package edu.gqq.future;

import java.util.ArrayList;
import java.util.List;

public class Explosion {
	private List<String> lstResults;

	public void addList() {
		lstResults = new ArrayList<String>();
		lstResults.add("Hello");
		lstResults.add("World");
	}

	public List<String> getResults() {
		return lstResults;
	}
}
