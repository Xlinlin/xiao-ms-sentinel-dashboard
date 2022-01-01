package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import com.alibaba.csp.sentinel.dashboard.config.NacosPropertiesConfig;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.RuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.nacos.api.config.ConfigService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class RuleNacosProvider<T extends RuleEntity> implements DynamicRuleProvider<List<T>> {

    @Autowired
    private NacosPropertiesConfig nacosPropertiesConfig;
    @Autowired
    protected ConfigService configService;
    @Autowired
    protected Converter<String, List<T>> converter;

    @Override
    public List<T> getRules(String appName) throws Exception {
        String rules = configService.getConfig(appName + getDataIdPostfix(),
                nacosPropertiesConfig.getGroupId(), 3000);
        if (StringUtil.isEmpty(rules)) {
            return new ArrayList<>();
        }
        return converter.convert(rules);
    }

    /**
     * 文件后缀 参考 com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil.FLOW_DATA_ID_POSTFIX
     *
     * @return
     */
    public abstract String getDataIdPostfix();
}
