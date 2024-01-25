package com.statusmanager.status;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StatusEntityConsumer {

  public void notificarInteressados(Status event) {
    log.info("ENTITY CONSUMER START: {}", event);
  }
}
