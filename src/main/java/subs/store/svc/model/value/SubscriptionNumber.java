package subs.store.svc.model.value;

public class SubscriptionNumber {

  private String value;

  SubscriptionNumber(final String value) {
    this.value = value;
  }

  public static SubscriptionNumber from(String subscriptionNumber) {
    return new SubscriptionNumber(subscriptionNumber);
  }

  public String getValue() {
    return value;
  }

}
