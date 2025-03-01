-- auto-generated definition
create table TODO
(
    ID                  INTEGER invisible auto_increment,
    SUMMARY             CHARACTER VARYING(250) not null,
    DEL_FLAG            INTEGER                not null,
    CREATE_TIME         TIMESTAMP              not null,
    UPDATE_TIME         TIMESTAMP              not null,
    REPEAT_PERIOD_TYPE  CHARACTER VARYING(255),
    REPEAT_PERIOD_VALUE INTEGER,
    TARGET_DATE_TYPE    CHARACTER VARYING(255) not null,
    TARGET_DATE_YEAR    CHARACTER VARYING(255) not null,
    TARGET_DATE_MONTH   CHARACTER VARYING(255) not null,
    TARGET_DATE_DAY     CHARACTER VARYING(255) not null,
    constraint TODO_PK
        primary key (ID)
);

comment on table TODO is '任务项';

comment on column TODO.SUMMARY is '描述';

comment on column TODO.DEL_FLAG is '0未删除，1已删除';

comment on column TODO.REPEAT_PERIOD_TYPE is '重复周期类型';

comment on column TODO.REPEAT_PERIOD_VALUE is '重复周期值';

comment on column TODO.TARGET_DATE_TYPE is '1公历2农历';

