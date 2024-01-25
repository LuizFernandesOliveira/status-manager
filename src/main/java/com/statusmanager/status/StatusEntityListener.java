package com.statusmanager.status;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StatusEntityListener {

  @Autowired
  private StatusEntityConsumer statusEntityConsumer;

  @PostPersist
  @PostUpdate
  @PostRemove
  private void afterAnyUpdate(Status status) {
    log.info("LISTENER START: {}", status);
    statusEntityConsumer.notificarInteressados(status);
  }
}
