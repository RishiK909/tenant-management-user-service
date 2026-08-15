CREATE TABLE tenants
(
    id                  UUID NOT NULL ,
    user_id             UUID,
    property_id         UUID,
    lease_start_date    DATE,
    lease_end_date      DATE,
    rent_amount         DECIMAL(10,2),
    rent_due_day        INT,

    created_at          TIMESTAMP WITHOUT TIME ZONE,
    created_by          UUID,
    updated_at          TIMESTAMP WITHOUT TIME ZONE,
    updated_by          UUID,
    deleted_at          TIMESTAMP WITHOUT TIME ZONE,
    status              VARCHAR(255),

    CONSTRAINT pk_tenants PRIMARY KEY (id),
    CONSTRAINT uk_tenants_user_id UNIQUE (user_id)
);