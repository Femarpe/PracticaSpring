CREATE USER IF NOT EXISTS "SA" SALT 'c986981333029c0a' HASH '8514b2792a0b5ddb40d48990e2409dfd39789cd5a5633e274b0069dca4debef2' ADMIN;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_501B6C96_7CD8_406C_8FC8_2593C26448FA" START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_0F7B51CC_78D6_4072_A778_EEF9FAEF7085" START WITH 1 BELONGS_TO_TABLE;
CREATE MEMORY TABLE "PUBLIC"."ARMA"(
    "ID_ARMA" BIGINT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_0F7B51CC_78D6_4072_A778_EEF9FAEF7085" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_0F7B51CC_78D6_4072_A778_EEF9FAEF7085",
    "DANYO" VARCHAR(255),
    "NOMBRE_ARMA" VARCHAR(255),
    "AVENTURERO" BIGINT
);
ALTER TABLE "PUBLIC"."ARMA" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1" PRIMARY KEY("ID_ARMA");
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.ARMA;
CREATE MEMORY TABLE "PUBLIC"."AVENTURERO"(
    "ID_ADV" BIGINT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_501B6C96_7CD8_406C_8FC8_2593C26448FA" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_501B6C96_7CD8_406C_8FC8_2593C26448FA",
    "NOMBRE_AVENTURERO" VARCHAR(255)
);
ALTER TABLE "PUBLIC"."AVENTURERO" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_8" PRIMARY KEY("ID_ADV");
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.AVENTURERO;
ALTER TABLE "PUBLIC"."ARMA" ADD CONSTRAINT "PUBLIC"."FK78SD07XFN38BGI7O9A6SMYNUV" FOREIGN KEY("AVENTURERO") REFERENCES "PUBLIC"."AVENTURERO"("ID_ADV") NOCHECK;