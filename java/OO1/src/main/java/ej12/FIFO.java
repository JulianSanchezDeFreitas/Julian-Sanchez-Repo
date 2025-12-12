package ej12;

import java.util.List;

public class FIFO implements Strategy {
	
	public FIFO() {
		
	}
	
	public JobDescription nextJob(List<JobDescription> jobs) {
		 JobDescription nextJob = jobs.get(0);
         return nextJob;
	}
}
