package com.mnptech.bcgen.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class PriceSystemReaderQuartzJob extends QuartzJobBean{
	
	@Autowired
	private PriceSystemReaderQuartzTask priceSystemReaderTask;
	
	

	public void setPriceSystemReaderTask(PriceSystemReaderQuartzTask priceSystemReaderTask) {
		this.priceSystemReaderTask = priceSystemReaderTask;
	}



	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		try {
			  priceSystemReaderTask.readPrice();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

}
