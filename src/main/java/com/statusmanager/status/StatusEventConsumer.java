package com.statusmanager.status;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import static org.springframework.transaction.event.TransactionPhase.AFTER_COMMIT;

@Component
@Slf4j
public class StatusEventConsumer {

  @TransactionalEventListener(phase = AFTER_COMMIT)
  public void notificarInteressados(Status event) {
    log.info("CONSUMER START: {}", event);
  }
}
