package ej12;

import java.util.List;

public interface Strategy {

	
	public JobDescription nextJob(List<JobDescription> jobs);
	
}
