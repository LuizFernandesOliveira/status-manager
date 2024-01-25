package com.statusmanager.status;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.Thread.sleep;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatusService {
  private final StatusRepository statusRepository;
  private final ApplicationEventPublisher publisher;

  @Transactional(propagation = REQUIRES_NEW)
  public void createStatus(Status status) {
    log.info("SERVICE START: {}", status);
    statusRepository.save(status);
    publisher.publishEvent(status);
    log.info("SERVICE END: {}", status);
    try {
      sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
