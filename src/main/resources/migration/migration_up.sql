CREATE TABLE "user" (
  "id" BIGSERIAL PRIMARY KEY,
  "username" VARCHAR(255) UNIQUE NOT NULL,
  "first_name" VARCHAR(255) NOT NULL,
  "middle_name" VARCHAR(255),
  "last_name" VARCHAR(255) NOT NULL,
  "created_at" timestamp DEFAULT (now())
);

CREATE TABLE "user_private" (
  "user_id" bigint PRIMARY KEY,
  "phone_number" VARCHAR(255) UNIQUE NOT NULL,
  "email" VARCHAR(255) UNIQUE NOT NULL,
  "password" VARCHAR(255) NOT NULL
);

CREATE TABLE "parking_slot" (
  "id" BIGSERIAL PRIMARY KEY,
  "address" VARCHAR(255) NOT NULL,
  "owner" bigint NOT NULL
);

CREATE TABLE "parking_slot_document" (
  "parking_slot_id" bigint PRIMARY KEY,
  "document" VARCHAR(255) NOT NULL
);

CREATE UNIQUE INDEX ON "user" ("id");

CREATE INDEX ON "user" ("first_name", "last_name");

CREATE UNIQUE INDEX ON "user_private" ("email");

CREATE UNIQUE INDEX ON "user_private" ("phone_number");

CREATE INDEX ON "parking_slot" ("address");

CREATE INDEX ON "parking_slot" ("owner");

CREATE INDEX ON "parking_slot_document" ("parking_slot_id");

COMMENT ON COLUMN "user_private"."phone_number" IS '+380%';

ALTER TABLE "user_private" ADD FOREIGN KEY ("user_id") REFERENCES "user" ("id");

ALTER TABLE "parking_slot" ADD FOREIGN KEY ("owner") REFERENCES "user" ("id");

ALTER TABLE "parking_slot_document" ADD FOREIGN KEY ("parking_slot_id") REFERENCES "parking_slot" ("id");
