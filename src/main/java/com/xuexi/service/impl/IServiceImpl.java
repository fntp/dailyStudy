package com.xuexi.service.impl;

import com.xuexi.service.IService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author fntp
 * @since 2024/10/28
 */
@Service
@NoArgsConstructor
public class IServiceImpl implements IService {

    @Override
    public String getName() {
        return "hello";
    }

}
