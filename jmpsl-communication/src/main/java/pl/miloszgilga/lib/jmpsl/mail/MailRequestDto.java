/*
 * Copyright (c) 2022 by multiple authors
 *
 * File name: MailRequestDto.java
 * Last modified: 18/10/2022, 15:03
 * Project name: jmps-library
 *
 * Licensed under the MIT license; you may not use this file except in compliance with the License.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * THE ABOVE COPYRIGHT NOTICE AND THIS PERMISSION NOTICE SHALL BE INCLUDED IN ALL
 * COPIES OR SUBSTANTIAL PORTIONS OF THE SOFTWARE.
 */

package pl.miloszgilga.lib.jmpsl.mail;

import lombok.*;
import java.util.*;

import static java.util.Objects.isNull;

/**
 * Simple POJO class responsible for stored all data for sending email, including sender, recievier and additional
 * attachements and inline resources for embeded email message.
 *
 * @author Miłosz Gilga
 * @since 1.0.2
 */
@Getter
@Setter
@Builder
@ToString
public class MailRequestDto {
    private Set<String> sendTo;
    private String sendFrom;
    private String messageSubject;
    private List<ResourceDto> inlineResources;
    private List<ResourceDto> attachments;

    public MailRequestDto(Set<String> sendTo, String sendFrom, String messageSubject,
                          List<ResourceDto> inlineResources, List<ResourceDto> attachments) {
        if (isNull(sendTo) || sendTo.isEmpty())
            throw new IllegalStateException("List of SendTo parameters cannot be null or empty.");
        if (isNull(sendFrom) || sendFrom.isBlank())
            throw new IllegalStateException("SendFrom parameter cannot be null or empty.");
        this.sendTo = sendTo;
        this.sendFrom = sendFrom;
        this.messageSubject = messageSubject;
        this.inlineResources = inlineResources;
        this.attachments = attachments;
    }
}
