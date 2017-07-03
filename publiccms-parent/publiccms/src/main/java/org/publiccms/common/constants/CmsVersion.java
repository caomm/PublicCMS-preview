package org.publiccms.common.constants;

import static config.spring.CmsConfig.CMS_FILEPATH;

import java.util.UUID;

import com.publiccms.common.base.Copyright;

/**
 *
 * CmsVersion
 *
 */
public class CmsVersion {
    private static final String clusterId = UUID.randomUUID().toString();
    private static boolean master = false;
    private static boolean initialized = false;
    private static Copyright copyright;

    /**
     * @return
     */
    public static final String getVersion() {
        return "V2017.0520";
    }

    /**
     * @return
     */
    public static boolean isPreview() {
        return false;
    }

    /**
     * @return
     */
    public static boolean isBusinessEdition() {
        return null != copyright && copyright.verify();
    }

    /**
     * @param activateCode
     * @return
     */
    public static boolean activate(String activateCode) {
        return !isBusinessEdition() && null != copyright && copyright.activate(activateCode);
    }

    /**
     * @return
     */
    public static final String getClusterId() {
        return clusterId;
    }

    /**
     * @return
     */
    public static boolean isMaster() {
        return master;
    }

    /**
     * @param master
     */
    public static void setMaster(boolean master) {
        CmsVersion.master = master;
    }

    /**
     * @return
     */
    public static boolean isInitialized() {
        return initialized;
    }

    /**
     * @param initialized
     */
    public static void setInitialized(boolean initialized) {
        CmsVersion.initialized = initialized;
        if (initialized && null == copyright) {
            try {
                Class<?> clazz = Class.forName("com.publiccms.improve.CmsCopyright");
                if (Copyright.class.isAssignableFrom(clazz)) {
                    copyright = (Copyright) clazz.newInstance();
                    copyright.init(CMS_FILEPATH);
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}