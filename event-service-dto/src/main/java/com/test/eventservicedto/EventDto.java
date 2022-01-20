package com.test.eventservicedto;

import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
public class EventDto {

    private long id;
    private String title;
    private String place;
    private String speaker;
    private String eventType;
    private LocalDateTime dateTime;

}
