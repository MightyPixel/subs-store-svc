# Subscription Store Service


## Setup

- Example Data

```
INSERT INTO "subs_store"."subscriptions" ("subscription_id", "subscription_provider", "subscription_status", "effective_start_date", "effective_end_date", "user_id") VALUES ('A-1235', 'Google', 'canceled', '2019-01-01 00:00:00 +0000', '2020-01-31 00:00:00 +0000', 9b93c7db-ea92-41ac-b6bd-cb7fd565e946);
INSERT INTO "subs_store"."subscriptions" ("subscription_id", "subscription_provider", "subscription_status", "effective_start_date", "effective_end_date", "user_id") VALUES ('A-123', 'FT', 'active', '2019-01-01 00:00:00 +0000', '2020-01-01 00:00:00 +0000', 9b93c7db-ea92-41ac-b6bd-cb7fd565e946);
INSERT INTO "subs_store"."subscriptions" ("subscription_id", "subscription_provider", "subscription_status", "effective_start_date", "effective_end_date", "user_id") VALUES ('A-1234', 'Google', 'active', '2019-02-01 00:00:00 +0000', '2020-02-01 00:00:00 +0000', 9b93c7db-ea92-41ac-b6bd-cb7fd565e946);
INSERT INTO "subs_store"."subscriptions" ("subscription_id", "subscription_provider", "subscription_status", "effective_start_date", "effective_end_date", "user_id") VALUES ('B-4123', 'FT', 'active', '2019-01-01 00:00:00 +0000', '2020-01-01 00:00:00 +0000', b0d77626-9d83-44f3-93c9-0ac0abc9c3fa);
```

- Example Queries
  - `SELECT * FROM "subs_store"."subscriptions" WHERE "subscription_id" = 'A-1234'`
  - `SELECT * FROM subscriptions_by_user where user_id = 9b93c7db-ea92-41ac-b6bd-cb7fd565e946 AND subscription_provider = 'Google';`