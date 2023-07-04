package mvcPractice;

import java.util.*;

public class StateSimpleMap
	implements StateLookupService {

	private Map<String, StatePair> states;
	
	 public StateSimpleMap() {
		states = new HashMap<String, StatePair>();
		addState(new StatePair("New York", "NY"));
		addState(new StatePair("Maryland", "MD"));
	}
	
	public StatePair findStatePair(String stateName) {
		if (stateName!= null) {
			return(states.get(stateName));
		} else
			return(null);
	}
	
	private void addState(StatePair statePair) {
		states.put(statePair.getStateName(), statePair);
	  }

}
