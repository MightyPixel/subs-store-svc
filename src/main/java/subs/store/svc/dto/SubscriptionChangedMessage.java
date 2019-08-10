package subs.store.svc.dto;

import lombok.Data;

@Data
public class SubscriptionChangedMessage {
  private String id;
  private String provider;
}
