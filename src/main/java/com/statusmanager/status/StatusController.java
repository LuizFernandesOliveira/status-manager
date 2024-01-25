package com.statusmanager.status;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class StatusController {
  private final StatusService statusService;

  @PostMapping("/")
  @Transactional
  public void createStatus() {
    Status status = Status.builder().id(UUID.randomUUID()).type("test").build();
    statusService.createStatus(status);
  }
}
