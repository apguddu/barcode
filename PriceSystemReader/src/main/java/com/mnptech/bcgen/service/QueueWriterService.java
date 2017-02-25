package com.mnptech.bcgen.service;

import javax.jms.JMSException;

public interface QueueWriterService {
  public void putPriceMessageToQueue(String message) throws JMSException;
}
