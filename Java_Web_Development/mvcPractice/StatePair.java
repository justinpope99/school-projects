package mvcPractice;

public class StatePair {
	private final String stateName, stateAbbreviation;
	
	public StatePair(String stateName, String stateAbbreviation) {
		this.stateName = stateName;
		this.stateAbbreviation = stateAbbreviation;
	}
	
	public String getStateName() {
		return stateName;
	}

	public String getStateAbbreviation() {
		return stateAbbreviation;
	}

}
