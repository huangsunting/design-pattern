package com.bravo.other.saga.v1.step;

import com.bravo.other.saga.v1.Context;

// 步骤接口：包含正向、逆向
public interface Step {
    void execute(Context context);

    void rollback(Context context);
}
