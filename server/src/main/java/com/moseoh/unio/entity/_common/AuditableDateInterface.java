package com.moseoh.unio.entity._common;

import java.time.LocalDateTime;

public interface AuditableDateInterface {
    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();
}
