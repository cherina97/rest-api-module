package com.test.eventservicedto;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column
    private String place;

    @Column
    private String speaker;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "date")
    private LocalDateTime dateTime;
}
