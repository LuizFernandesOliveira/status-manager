package com.statusmanager.status;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EntityListeners(StatusEntityListener.class)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Status {
  @Id private UUID id;

  private String type;

  @Override
  public String toString() {
    return "Status(id=" + this.getId() + ", type=" + this.getType() + ")";
  }
}
