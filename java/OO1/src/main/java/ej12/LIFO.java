package ej12;

import java.util.List;

public class LIFO implements Strategy{
	
	public LIFO() {
		
	}
	
	public JobDescription nextJob(List<JobDescription> jobs) {
		JobDescription nextJob = jobs.get(jobs.size()-1);
        return nextJob;
	}

}
