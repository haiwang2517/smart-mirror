package cn.haiyinlong.smart.mirror.domain.model;

import lombok.Getter;

/**
 * CalendarEnum
 * @author HaiYinLong
 * @version 2025/02/28 15:23
**/
@Getter
public enum CalendarEnum {
    SOLAR(1),
    LUNAR(2) ;
    private final int type;

    CalendarEnum(int type) {
        this.type = type;
    }
}
