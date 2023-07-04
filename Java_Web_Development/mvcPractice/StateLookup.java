package mvcPractice;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/state-lookup")
public class StateLookup extends HttpServlet implements StateLookupService {
	
	private Map<String, StatePair> states;
	
	@Override
	public void doGet(HttpServletRequest request,
			  		  HttpServletResponse response)
		throws ServletException, IOException {
		
			states = new HashMap<String, StatePair>();
			addState(new StatePair("New York", "NY"));
			addState(new StatePair("Maryland", "MD"));
		
			String stateParam = request.getParameter("stateParam");
		    StatePair statePair = findStatePair(stateParam);
		    request.setAttribute("statePair", statePair);
			
		    String address;
			if (stateParam == null || stateParam.trim().equals("")) {
				address = "missingdata.jsp";
			} else if (stateParam != null && statePair == null) {
				address = "unknown-state.jsp";
			} else {
				address = "showStateAbb.jsp";
			}
			
			RequestDispatcher dispatcher =
				      request.getRequestDispatcher(address);
				    dispatcher.forward(request, response);
		
		
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

	
	@Override
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
	}
}
