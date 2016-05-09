# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table adhar_card_model (
  adhar_no                  bigserial not null,
  country                   varchar(255),
  details                   varchar(255),
  person_person_id          bigint,
  constraint uq_adhar_card_model_person_perso unique (person_person_id),
  constraint pk_adhar_card_model primary key (adhar_no))
;

create table course_model (
  course_id                 bigserial not null,
  course_name               varchar(255),
  course_fee                float,
  constraint pk_course_model primary key (course_id))
;

create table person_model (
  person_id                 bigserial not null,
  person_name               varchar(255),
  age                       integer,
  constraint pk_person_model primary key (person_id))
;

create table student_model (
  sid                       bigserial not null,
  sname                     varchar(255),
  branch                    varchar(255),
  constraint pk_student_model primary key (sid))
;


create table student_course (
  course_model_course_id         bigint not null,
  student_model_sid              bigint not null,
  constraint pk_student_course primary key (course_model_course_id, student_model_sid))
;
alter table adhar_card_model add constraint fk_adhar_card_model_person_1 foreign key (person_person_id) references person_model (person_id);
create index ix_adhar_card_model_person_1 on adhar_card_model (person_person_id);



alter table student_course add constraint fk_student_course_course_mode_01 foreign key (course_model_course_id) references course_model (course_id);

alter table student_course add constraint fk_student_course_student_mod_02 foreign key (student_model_sid) references student_model (sid);

# --- !Downs

drop table if exists adhar_card_model cascade;

drop table if exists course_model cascade;

drop table if exists student_course cascade;

drop table if exists person_model cascade;

drop table if exists student_model cascade;

