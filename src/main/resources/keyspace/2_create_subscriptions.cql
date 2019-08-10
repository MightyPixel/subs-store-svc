CREATE TABLE subscriptions (
  subscription_id text,
  subscription_status text,
  subscription_provider text,
  effective_start_date TIMESTAMP,
  effective_end_date TIMESTAMP,
  user_id uuid,
  PRIMARY KEY ((subscription_id),
    subscription_provider,
    effective_start_date,
    effective_end_date
  )) WITH CLUSTERING ORDER BY (subscription_provider ASC,
    subscription_status ASC,
    effective_start_date DESC,
    effective_end_date DESC);


CREATE MATERIALIZED VIEW subscriptions_by_google_order_id AS
	SELECT google_order_id, subscription_id, subscription_provider, subscription_status, effective_start_date, effective_end_date, user_id
	FROM subscriptions
	WHERE
		google_order_id IS NOT NULL
		AND subscription_id IS NOT NULL
		AND subscription_provider IS NOT NULL
		AND subscription_status IS NOT NULL
		AND effective_start_date IS NOT NULL
		AND effective_end_date IS NOT NULL
		AND user_id IS NOT NULL
	PRIMARY KEY (
	    (google_order_id),
	    subscription_provider,
	    effective_start_date,
	    effective_end_date,
	    subscription_id
  	);

CREATE MATERIALIZED VIEW subscriptions_by_user AS
	SELECT subscription_id, subscription_provider, subscription_status, effective_start_date, effective_end_date, user_id
	FROM subscriptions
	WHERE subscription_id IS NOT NULL
		AND subscription_provider IS NOT NULL
		AND subscription_status IS NOT NULL
		AND effective_start_date IS NOT NULL
		AND effective_end_date IS NOT NULL
		AND user_id IS NOT NULL
	PRIMARY KEY (
	    (user_id),
	    subscription_provider,
	    effective_start_date,
	    effective_end_date,
	    subscription_id
  	);


CREATE MATERIALIZED VIEW subscriptions_ AS
	SELECT subscription_id, subscription_provider, subscription_status, effective_start_date, effective_end_date, user_id
	FROM subscriptions
	WHERE subscription_id IS NOT NULL
		AND subscription_provider IS NOT NULL
		AND subscription_status IS NOT NULL
		AND effective_start_date IS NOT NULL
		AND effective_end_date IS NOT NULL
		AND user_id IS NOT NULL
	PRIMARY KEY (
	    (user_id),
	    subscription_provider,
	    effective_start_date,
	    effective_end_date,
	    subscription_id
  	);
