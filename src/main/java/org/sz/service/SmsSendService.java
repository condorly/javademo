package org.sz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sz.entity.SmsSend;
import org.sz.mapper.SmsSendMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SmsSendService {
    @Autowired
    private SmsSendMapper smsSendMapper;

    public List<SmsSend> sendSms(String mobile, String message) {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("mobile", mobile);
        List<SmsSend> smsSends = smsSendMapper.selectByMap(columnMap);

        return smsSends;
    }
}
