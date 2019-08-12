package subs.store.svc.model.value;

public class SubscriptionProvider {

  private String value;

  SubscriptionProvider(String value) {
    this.value = value;
  }

  public static SubscriptionProvider from(final String value) {
    return new SubscriptionProvider(value);
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return value;
  }
}
