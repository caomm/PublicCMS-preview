package com.publiccms.common.tools;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.publiccms.entities.sys.SysExtendField;
import com.publiccms.views.pojo.ExtendData;
import com.publiccms.views.pojo.ExtendField;
import com.sanluan.common.api.Json;
import com.sanluan.common.base.Base;

/**
 *
 * ExtendUtils
 * 
 */
public class ExtendUtils extends Base implements Json{
    
    /**
     * @param extendDataList
     * @param sysExtendFieldList
     * @return
     */
    public static Map<String, String> getSysExtentDataMap(List<ExtendData> extendDataList,
            List<SysExtendField> sysExtendFieldList) {
        Map<String, String> map = new HashMap<String, String>();
        if (notEmpty(extendDataList)) {
            Map<String, String> extendFieldMap = new HashMap<String, String>();
            for (ExtendData extend : extendDataList) {
                extendFieldMap.put(extend.getName(), extend.getValue());
            }
            for (SysExtendField extend : sysExtendFieldList) {
                String value = extendFieldMap.get(extend.getId().getCode());
                if (null == value) {
                    map.put(extend.getId().getCode(), extend.getDefaultValue());
                } else {
                    map.put(extend.getId().getCode(), value);
                }
            }
        }
        return map;
    }

    /**
     * @param extendDataList
     * @param extendFieldList
     * @return
     */
    public static Map<String, String> getExtentDataMap(List<ExtendData> extendDataList, List<ExtendField> extendFieldList) {
        Map<String, String> map = new HashMap<String, String>();
        if (notEmpty(extendDataList)) {
            Map<String, String> extendFieldMap = new HashMap<String, String>();
            for (ExtendData extend : extendDataList) {
                extendFieldMap.put(extend.getName(), extend.getValue());
            }
            for (ExtendField extend : extendFieldList) {
                String value = extendFieldMap.get(extend.getId().getCode());
                if (null == value) {
                    map.put(extend.getId().getCode(), extend.getDefaultValue());
                } else {
                    map.put(extend.getId().getCode(), value);
                }
            }
        }
        return map;
    }

    /**
     * @param data
     * @return
     */
    public static Map<String, String> getExtendMap(String data) {
        if (notEmpty(data)) {
            try {
                return objectMapper.readValue(data, new TypeReference<Map<String, String>>() {

                });
            } catch (IOException | ClassCastException e) {
                return new HashMap<String, String>();
            }
        }
        return new HashMap<String, String>();

    }

    /**
     * @param map
     * @return
     */
    public static String getExtendString(Map<String, String> map) {
        try {
            return objectMapper.writeValueAsString(map);
        } catch (IOException e) {
            return null;
        }
    }
}