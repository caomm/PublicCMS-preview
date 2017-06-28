package com.publiccms.common.base;

public interface Copyright {
    public boolean verify(String dataFilePath);

    public boolean activate(String activateCode);
}
