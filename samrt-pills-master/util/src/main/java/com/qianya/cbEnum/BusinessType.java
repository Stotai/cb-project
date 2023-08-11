package com.qianya.cbEnum;

public enum BusinessType {
    OTHER,
    INSERT,
    UPDATE,
    DELETE,
    GRANT,
    EXPORT,
    IMPORT,
    FORCE,
    GENCODE,
    CLEAN,
    AUDIT;

    private BusinessType() {
    }
}