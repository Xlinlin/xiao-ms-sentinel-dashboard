package com.alibaba.csp.sentinel.dashboard.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * nacos配置 <br>
 *
 * @date: 2021/12/15 <br>
 * @author: llxiao <br>
 * @since: 1.0 <br>
 * @version: 1.0 <br>
 */
@ConfigurationProperties(prefix = "spring.cloud.sentinel.datasource.nacos")
@Configuration
public class NacosPropertiesConfig {

    private String namespace;
    private String serverAddr;
    private String username;
    private String password;
    private String groupId = "DEFAULT_GROUP";


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }
}
