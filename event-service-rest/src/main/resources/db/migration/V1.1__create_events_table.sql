create table events
(
    id         serial       not null primary key,
    title      varchar(255) not null,
    place      varchar(255) not null,
    speaker    varchar(255) not null,
    event_type varchar(255) not null,
    date       date         not null
);